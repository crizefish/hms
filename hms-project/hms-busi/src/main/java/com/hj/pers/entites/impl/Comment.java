package com.hj.pers.entites.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity(name="comment")
public class Comment {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	private Long replyId;
	
	private String replyName;
	
	private Long beReplyId;
	
	private String beReplyName;
	
	private String content;
	
	private Date createTime;
	
	private Long parentId;
	
	private String articleId;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	@JoinColumn(name="parentId")
	@OrderBy(value="createTime")
	private List<Comment> replyBody;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getReplyId() {
		return replyId;
	}
	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}
	public String getReplyName() {
		return replyName;
	}
	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}
	public Long getBeReplyId() {
		return beReplyId;
	}
	public void setBeReplyId(Long beReplyId) {
		this.beReplyId = beReplyId;
	}
	public String getBeReplyName() {
		return beReplyName;
	}
	public void setBeReplyName(String beReplyName) {
		this.beReplyName = beReplyName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<Comment> getReplyBody() {
		return replyBody;
	}
	public void setReplyBody(List<Comment> replyBody) {
		this.replyBody = replyBody;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

}
