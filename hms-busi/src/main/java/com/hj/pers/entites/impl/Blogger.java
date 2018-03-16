package com.hj.pers.entites.impl;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hj.pers.entites.Base;

/**
 * 博客实体
 * 
 * @author hujian
 *
 */
@Entity
@Table(name = "blogger")
public class Blogger extends Base {
	// id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	// 标题
	@Column(name = "title")
	private String title;
	// 关键字
	@Column(name = "key_word")
	private String keyWord;
	// 语言类型
	@Column(name = "type")
	private String type;
	// 文章内容
	@Column(name = "content")
	private String content;
	// 谁可见
	@Column(name = "whose_read")
	private String whoseRead;
	// 点赞数
	@Column(name = "top_Num")
	private String topNum;
	// 阅读量
	@Column(name = "read_Num")
	private String readNum;
	// 文章类型
	@Column(name = "article_Kind")
	private String articleKind;
	// 标签
	@Column(name = "label")
	private String label;
	// 相关标签
	@Column(name = "other_Url")
	private String otherUrl;

	// 相关标签
	@Column(name = "out_line")
	private String outLine;

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

	public String getTopNum() {
		return topNum;
	}

	public void setTopNum(String topNum) {
		this.topNum = topNum;
	}

	public String getReadNum() {
		return readNum;
	}

	public void setReadNum(String readNum) {
		this.readNum = readNum;
	}

	public String getArticleKind() {
		return articleKind;
	}

	public void setArticleKind(String articleKind) {
		this.articleKind = articleKind;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOtherUrl() {
		return otherUrl;
	}

	public void setOtherUrl(String otherUrl) {
		this.otherUrl = otherUrl;
	}

	public String getOutLine() {
		return outLine;
	}

	public void setOutLine(String outLine) {
		this.outLine = outLine;
	}
}
