package com.hj.pers.pojo;

public class Page {

	private int totle_num;
	private int current_num;
	private int page_size;
	private int page_from;

	public Page() {
		super();
	}

	public Page(int totle_num, int current_num) {
		super();
		this.totle_num = totle_num;
		this.current_num = current_num;
	}

	public int getTotle_num() {
		return totle_num;
	}

	public void setTotle_num(int totle_num) {
		this.totle_num = totle_num;
	}

	public int getCurrent_num() {
		return current_num;
	}

	public void setCurrent_num(int current_num) {
		this.current_num = current_num;
	}

	public int getPage_size() {
		return page_size;
	}

	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}

	public int getPage_from() {
		return page_from;
	}

	public void setPage_from(int page_from) {
		this.page_from = page_from;
	}

}
