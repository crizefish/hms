package com.hj.pers.pojo.news;

public class NewsRequest {
	private Result result;
	private String error_code;
	private String reason;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Result [result=" + result + ", error_code=" + error_code + ", reason=" + reason + "]";
	}

}
