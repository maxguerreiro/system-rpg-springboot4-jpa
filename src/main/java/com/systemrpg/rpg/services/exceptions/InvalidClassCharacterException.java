package com.systemrpg.rpg.services.exceptions;

/**
 * Exception thrown when an invalid character class is provided.
 */
public class InvalidClassCharacterException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidClassCharacterException(String className) {
		super("Invalid character class: " + className);
	}
}
