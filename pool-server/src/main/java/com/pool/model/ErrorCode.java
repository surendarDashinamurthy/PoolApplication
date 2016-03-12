package com.pool.model;
/**
 * Code returned to the Client indicating the state of the server
 * 
 * @author AtoS
 *
 */

public class ErrorCode {
    

	String code;
	
	String message;
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	// Compulsory fields to have a error object
	public ErrorCode(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}



}
