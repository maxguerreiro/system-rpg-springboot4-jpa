package com.systemrpg.rpg.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.systemrpg.rpg.services.exceptions.InvalidClassCharacterException;
import com.systemrpg.rpg.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Global exception handler for REST controllers.
 * This class intercepts exceptions thrown by the application and
 * converts them into standardized HTTP responses.
 */
@ControllerAdvice
@RestControllerAdvice
public class ResourceExceptionHandler {

	/**
	 * Handles ResourceNotFoundException and returns a structured
	 * HTTP 404 response.
	 *
	 * @param e The exception thrown
	 * @param request The HTTP request that caused the exception
	 * @return ResponseEntity containing the standardized error response
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(InvalidClassCharacterException.class)
	public ResponseEntity<StandardError> invalidClassCharacterException(InvalidClassCharacterException e, HttpServletRequest request) {
		String error = "Invalid class";
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
