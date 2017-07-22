package com.flikon.salesforce;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseStatus {

	@JsonProperty("Response Status")
	private String status;
	
	@JsonProperty("Response Text")
	private String text;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
