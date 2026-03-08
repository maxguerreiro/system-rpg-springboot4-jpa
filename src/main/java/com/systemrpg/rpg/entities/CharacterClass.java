package com.systemrpg.rpg.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * Represents the blueprint for character classes in the system.
 * Defines the initial growth and available resources for a specific role.
 */
@Entity
public class CharacterClass implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Embedded
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