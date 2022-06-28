package com.example.demo.Exception;

import java.util.Date;

import javax.xml.crypto.Data;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException{

	private Date timestamp;
	private String message;
	private String url;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ControllerException(Date timestamp, String message, String url) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.url = url;
	}
	public ControllerException() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ControllerException [timestamp=" + timestamp + ", message=" + message + ", url=" + url + "]";
	}
	
	
}
