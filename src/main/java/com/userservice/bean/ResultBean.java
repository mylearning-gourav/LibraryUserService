package com.userservice.bean;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultBean {
	
	private int statusCode;
	private String statusMessage;
	private HashMap<String, ArrayList<Object>> result;
	
	public ResultBean() {
		statusCode = 2000;
		statusMessage = "Success";
	}
	
	public ResultBean(int statusCode, String statusMessage) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}
	
	public ResultBean(int statusCode, String statusMessage, HashMap<String, ArrayList<Object>> result) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.result = result;
	}
	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public HashMap<String, ArrayList<Object>> getResult() {
		return result;
	}

	public void setResult(HashMap<String, ArrayList<Object>> result) {
		this.result = result;
	}
}
