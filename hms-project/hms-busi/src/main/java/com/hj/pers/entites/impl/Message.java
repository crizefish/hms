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

import com.hj.pers.entites.Base;

@Entity(name="message")
public class Message extends Base{
			//id
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
			
			private Long LikeNum;
			
			private Long unLikeNum;
			
			private String address;
			
			@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
			@JoinColumn(name="parentId")
			@OrderBy(value="createTime")
			private List<Message> replyBody;

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

			public Long getLikeNum() {
				return LikeNum;
			}

			public void setLikeNum(Long likeNum) {
				LikeNum = likeNum;
			}

			public Long getUnLikeNum() {
				return unLikeNum;
			}

			public void setUnLikeNum(Long unLikeNum) {
				this.unLikeNum = unLikeNum;
			}

			public String getAddress() {
				return address;
			}

			public void setAddress(String address) {
				this.address = address;
			}

			public List<Message> getReplyBody() {
				return replyBody;
			}

			public void setReplyBody(List<Message> replyBody) {
				this.replyBody = replyBody;
			}

			

			
}
