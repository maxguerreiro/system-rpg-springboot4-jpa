package com.systemrpg.rpg.services.exceptions;

/**
 * Custom exception thrown when a requested resource is not found in the database.
 * 
 * This exception is typically used in service layer methods when an entity
 * cannot be located by its identifier.
 * 
 */
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new ResourceNotFoundException with a custom message
	 * containing the resource identifier.
	 *
	 * @param id Identifier of the resource that was not found
	 */
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}
}
