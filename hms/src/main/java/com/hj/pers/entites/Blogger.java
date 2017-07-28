package com.hj.pers.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "blogger")
public class Blogger {
	
	  @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private Long id;
	@Column(name="title")
	private String title;
	
	@Column(name="key_word")
	private String keyWord;
	
	@Column(name="type")
	private String type;
	
	@Column(name="content")
	private String content;
	
	@Column(name="whose_read")
	private String whoseRead;
	
	@Column(name="create_by")
	private Long createBy;
	
	@Column(name="create_date")
	@DateTimeFormat(pattern="yyyy_MM_dd")
	private Date createDate;
	
	public Blogger(String title, String keyWord, String type, String content, String whoseRead, Long createBy,
			Date createDate) {
		super();
		this.title = title;
		this.keyWord = keyWord;
		this.type = type;
		this.content = content;
		this.whoseRead = whoseRead;
		this.createBy = createBy;
		this.createDate = createDate;
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Blogger() {
		super();
	}

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWhoseRead() {
		return whoseRead;
	}
	public void setWhoseRead(String whoseRead) {
		this.whoseRead = whoseRead;
	}
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString(){
		return "id:" + this.getId()+",createDate:"+this.getCreateDate();
	}
	
}
