// JavaScript Document
	$("#search_button").click(function sub(){
		var keyWord = $("#keyWord").val();
		if(keyWord=="请输入关键字" || keyWord == ""){
			window.location.href="/other/index";
		}else{
			window.location.href="/other/search"+"?keyWord="+keyWord;
		}
	});