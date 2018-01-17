package com.hj.pers.pojo.article;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Common {

	private String title;

	private String date;

	private String type;

	private String typeName;

	private String author;

	private Long authorId;

	private Long id;

	private String uri;

	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void brushColor(String keyWord) {
		if (!StringUtils.isEmpty(keyWord)) {
			if (this.title.contains(keyWord)) {
				String newTitle = this.title.replaceAll(keyWord, "<span style=\"color:red\">" + keyWord + "</span>");
		this.title = newTitle;
			}
			if (!StringUtils.isEmpty(this.content)&&this.content.contains(keyWord)) {
				String newContent = this.content.replaceAll(keyWord, "<span style=\"color:red\">" + keyWord + "</span>");
		this.content = newContent;
			}
		}

	}

	public String getDate() {
		return date.substring(0, 10);
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
		if (this.type.equals("blogger")) {
			this.typeName = "技术博客";
		} else if (this.type.equals("resource")) {
			this.typeName = "JAVA类库";
		} else if (this.type.equals("note")) {
			this.typeName = "随谈杂记";
		} else {
			this.typeName = null;
		}
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getUri() {
		if (this.uri == null) {
			return "/" + type + "/detail?" + type + "Id=" + id;
		} else {
			return uri;
		}
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
