package com.hj.pers.entites;

import java.util.ArrayList;
import java.util.List;


public class Result {
	private List<News> data = new ArrayList<>();
	
	public List<News> getData() {
		return data;
	}
	public void setData(List<News> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [data=" + data + ", error_code=" + "]";
	}
	
}
