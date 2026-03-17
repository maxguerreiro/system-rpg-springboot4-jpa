package com.systemrpg.rpg.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

/**
 * Standard structure for API error responses.
 
 * This class is used to provide consistent error information to clients,
 * including timestamp, HTTP status, error type, detailed message,
 * and request path.
 */
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public StandardError() {
	}

	/**
	 * Constructs a StandardError object with all error details.
	 *
	 * @param timestamp The moment when the error occurred
	 * @param status HTTP status code
	 * @param error Short description of the error
	 * @param message Detailed error message
	 * @param path Request path where the error happened
	 */
	public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
