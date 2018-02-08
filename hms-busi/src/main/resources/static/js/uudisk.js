// JavaScript Document
$(document).ready(function(){
	
	getFileDetail("C:\\Users\\hujian\\Desktop\\hmsbuilder");
	
	//首先将#back-to-top隐藏
	$("#back-to-top").hide();
	//当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
	$(function () {
		$(window).scroll(function(){
		if ($(window).scrollTop()>100){
		$("#back-to-top").fadeIn(1500);
		}
		else
		{
		$("#back-to-top").fadeOut(1500);
		}
		});
		//当点击跳转链接后，回到页面顶部位置
		$("#back-to-top").click(function(){
		$('body,html').animate({scrollTop:0},500);
		return false;
		});
		});
	//点击视图切换图片
	$("#menu_list").toggle(
        function(){
            $(this).addClass("menu_right");
        },
        function(){
            $(this).removeClass("menu_right");
        }
    );
	$('#toMyShare').click(function(){
		$('#disk_nav_arrow').addClass('arrow_share');
	});
	$('#toMyComputer').click(function(){
		$('#disk_nav_arrow').removeClass('arrow_share');
	});
	//触发ajax内容单击事件
		$('body').on('click', '.clickMe', function(){
		var nowId=$(this).attr('id');
		var nowPath=$('#'+nowId+' input').val();
		getFileDetail(nowPath);
	});
	//根据状态栏获取目录目录
		$('body').on('click', '.location_show.other', function(){
		$('#disk_path').html('<a href="javascript:void(0);" class="location_showq" id="to_root_nav" style="float:left">目录:&nbsp&nbsp&nbsp&nbsp</a>');
		getFileDetail($(this).attr("value"));
	});
	
	$('#get_root_a').click(getRootDetail);
	/*$('body').on('click', '#to_root_nav', getRootDetail);*/
	//用tooltip显示文件信息
	//$('#showContent .fileDetail').tooltip();
		
	function getRootDetail(){
		alert("")
		$('#showContent').before('<p id="reload_gif"><img src="../images/load.gif" width="25px"  height="25px"  align="absmiddle"/>&nbsp;&nbsp;正在加载……</p>');
		$.ajax({
			type:"post",
			url:"/introduction/iterateRoot",
			async:true,
			dataType:"JSON",
			success:function(data){
				$('#reload_gif').remove();
				$('#showContent').html("");
				$('#disk_path').html('<a href="javascript:void(0);" class="location_showq" id="to_root_nav" style="float:left">目录:&nbsp&nbsp&nbsp&nbsp</a>');
				$.each(data,function(i,item){
					if(item.diskName=='C'){
						$('#showContent').append('<a href="javascript:void(0);" class="clickMe" id="disk_'+i+'"><p><img src="../images/disk_c.png" class="disk_c_img" align="absmiddle"/>&nbsp;&nbsp;&nbsp;&nbsp;容量：'+item.diskSize+'&nbsp;&nbsp&nbsp;&nbsp;剩余空间：'+item.avilableSize+'<input type="hidden" value='+item.diskPath+'/></p></a>');
					}else{
						$('#showContent').append('<a href="javascript:void(0);" class="clickMe" id="disk_'+i+'"><p ><img src="../images/disk_other.png" class="disk_c_img" align="absmiddle"/>&nbsp;&nbsp;&nbsp;&nbsp;容量：'+item.diskSize+'&nbsp;&nbsp;&nbsp;&nbsp;剩余空间：'+item.avilableSize+'<input type="hidden" value='+item.diskPath+'/></p></a>');
					}
				});
			}
		});
	}
	function getFileDetail(nowPath){
		$('#showContent').before('<p id="reload_gif"><img src="../images/load.gif" width="25px"  height="25px"  align="absmiddle"/>&nbsp;&nbsp;正在加载……</p>');
		$.ajax({
			type:"post",
			url:"/introduction/iterateDir",
			data: "path="+nowPath,
			async:true,
			dataType:"JSON",
			success:function(data){
				$('#reload_gif').remove();
				$('#showContent').html("");
				$.each(data,function(i,item){
					var pp = item.dirPath;
					var d = pp.substr(pp.lastIndexOf('\\')+1,pp.lengh);
					$('#disk_path').append('<a href="javascript:void(0);"value="'+pp+'" class="location_show other">'+d+'>></a>');
					$.each(item.files,function(n,file){
						if(file.fileType=='DIR'){
							$('#showContent').append('<div class="fileDetail"><a href="javascript:void(0);" class="clickMe" id="file_'+n+'"><img src="../images/floder.png" title="'+file.fileName+'"/><span>'+file.fileName+'</span><input type="hidden" value='+file.filePath+'/></a></div>');
						}
						else if(file.fileType=='TXT'||file.fileType=='JAVA'||file.fileType=='PDF'){
							var p= file.filePath;
							var b='\\\\';
							var filePath = p.replace(/\\/g,b);
							$('#showContent').append('<div class="fileDetail"><a  href="#" onclick=\'showDetail("'+file.fileType+'","'+filePath+'")\'><img src="../images/txt.png" title="大小：'+file.fileSize+'&#10;'+file.fileName+'"/><span>'+file.fileName+'</span></a></div>');
						}												
						else if(file.fileType=='MP3'||file.fileType=='WMA'||file.fileType=='WAV'||file.fileType=='MOD'){
							$('#showContent').append('<div class="fileDetail"><a href="javascript:void(0);"><img src="../images/music.png" title="大小：'+file.fileSize+'&#10;'+file.fileName+'"/><span>'+file.fileName+'</span></a></div>');
						}
						else if(file.fileType=='HTML'||file.fileType=='HTM'||file.fileType=='JSP'){
							$('#showContent').append('<div class="fileDetail"><a href="javascript:void(0);"><img src="../images/html.png" title="大小：'+file.fileSize+'&#10;'+file.fileName+'"/><span>'+file.fileName+'</span></a></div>');
						}
						else if(file.fileType=='RAR'||file.fileType=='JAR'||file.fileType=='ZIP'){
							$('#showContent').append('<div class="fileDetail"><a href="javascript:void(0);"><img src="../images/zip.png" title="大小：'+file.fileSize+'&#10;'+file.fileName+'"/><span>'+file.fileName+'</span></a></div>');
						}
						else if(file.fileType=='DOC'||file.fileType=='WPS'||file.fileType=='DOCX'){
							var p= file.filePath;
							var b='\\\\';
							var filePath = p.replace(/\\/g,b);
							$('#showContent').append('<div class="fileDetail"><a  href="#" onclick=\'showDetail("'+file.fileType+'","'+filePath+'")\'><img src="../images/word.png" title="大小：'+file.fileSize+'&#10;'+file.fileName+'"/><span>'+file.fileName+'</span></a></div>');
						}
						else if(file.fileType=='XLS'){
							$('#showContent').append('<div class="fileDetail"><a href="javascript:void(0);"><img src="../images/excel.png" title="大小：'+file.fileSize+'&#10;'+file.fileName+'"/><span>'+file.fileName+'</span></a></div>');
						}
						else if(file.fileType=='PPT'){
							$('#showContent').append('<div class="fileDetail"><a href="javascript:void(0);"><img src="../images/ppt.png" title="大小：'+file.fileSize+'&#10;'+file.fileName+'"/><span>'+file.fileName+'</span></a></div>');
						}
						else if(file.fileType=='EXE'||file.fileType=='BAT'){
							$('#showContent').append('<div class="fileDetail"><a href="javascript:void(0);"><img src="../images/exe.png" title="大小：'+file.fileSize+'&#10;'+file.fileName+'"/><span>'+file.fileName+'</span></a></div>');
						}
						else if(file.fileType=='BMP'||file.fileType=='PNG'||file.fileType=='GIF'||file.fileType=='JPEG'||file.fileType=='JPG'){
							$('#showContent').append('<div class="fileDetail"><a href="javascript:void(0);"><img src="../images/photo.png" title="大小：'+file.fileSize+'&#10;'+file.fileName+'"/><span>'+file.fileName+'</span></a></div>');
						}
						else if(file.fileType=='RMVB'||file.fileType=='MKV'||file.fileType=='MP4'||file.fileType=='AVI'||file.fileType=='WMV'||file.fileType=='3GP'){
							$('#showContent').append('<div class="fileDetail"><a href="javascript:void(0);"><img src="../images/movie.png" title="大小：'+file.fileSize+'&#10;'+file.fileName+'"/><span>'+file.fileName+'</span></a></div>');
						}
						else{
							$('#showContent').append('<div class="fileDetail"><a href="javascript:void(0);"><img src="../images/config.png" title="大小：'+file.fileSize+'&#10;'+file.fileName+'"/><span>'+file.fileName+'</span></a></div>');
						}
					});
				});
			}
		});
	}
	
});
function showDetail(type,path){
    event.preventDefault();//使a自带的方法失效，即无法调整到href中的URL(http://www.baidu.com)
    if(type=='TXT'||type=='DOC'){
    	$.ajax({
    		type: "POST",
    		url: "/introduction/viewOnline",
    		data: "path="+path,
    		dataType:"JSON",
    		success:function(data){
				$('#reload_gif').remove();
				$('#showContent').html(data.content);
    		},
    		error: function(result){
    			//请求失败之后的操作
    		}
    	});
    }
}
