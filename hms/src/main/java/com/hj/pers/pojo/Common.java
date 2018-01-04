package com.hj.pers.pojo;


public class Common {
	
	private String title;
	
	private String date;
	
	private String type;
	
	private String typeName;
	
	private String author;
	
	private Long authorId;
	
	private Long id;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		if(this.type.equals("blogger")){
			this.typeName = "技术博客";
		}else if(this.type.equals("resource")){
			this.typeName = "JAVA类库";
		}else if(this.type.equals("note")){
			this.typeName = "随谈杂记";
		}else {
			this.typeName = null;
		}
	}
	
}
