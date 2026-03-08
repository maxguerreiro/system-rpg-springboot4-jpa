package com.systemrpg.rpg.entities;

import java.io.Serializable;
import java.util.Objects;


/**
 * Represents the blueprint for character classes in the system.
 * Defines the initial growth and available resources for a specific role.
 */
public class CharacterClass implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Attributes attributes;
	
	public CharacterClass() {
	}

	public CharacterClass(Long id, String name, Attributes attributes) {
		super();
		this.id = id;
		this.name = name;
		this.attributes = attributes;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterClass other = (CharacterClass) obj;
		return Objects.equals(id, other.id);
	}
}