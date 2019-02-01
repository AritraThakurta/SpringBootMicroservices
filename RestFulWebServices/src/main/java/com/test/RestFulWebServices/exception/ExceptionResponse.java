package com.test.RestFulWebServices.exception;

import java.util.Date;

/**
 * @author Dell
 *
 */
public class ExceptionResponse {
	
	/**
	 * This defines the timestamp for a particular exception
	 */
	private Date timeStamp;
	
	/**
	 * This defines the message for a particular exception
	 */
	private String message;
	
	/**
	 * 
	 */
	private String detail;

	public ExceptionResponse(Date timeStamp, String message, String detail) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.detail = detail;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	

}
