package com.student.mycart.commonresponse;

public class Response {
	
	private int statuscode;
	private Object data;
	private Object error;
	private String description;
	private String suggestion;
	
	
	
	public Response() {
		super();
		this.statuscode = 200;
		this.data = data;
		this.error = "No error";
		this.description = "Created Successfully";
		this.suggestion = "No suggestion";
	}
	
	
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	
}
