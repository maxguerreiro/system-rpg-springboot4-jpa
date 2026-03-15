package com.systemrpg.rpg.dtos;

import java.io.Serializable;

import com.systemrpg.rpg.entities.CharacterAttributes;
import com.systemrpg.rpg.entities.CharacterClass;

public class CharacterClassDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private CharacterAttributes attributes;
	
	public CharacterClassDTO() {
	}

	public CharacterClassDTO(String name, CharacterAttributes attributes) {
		super();
		this.name = name;
		this.attributes = attributes;
	}
	
	public CharacterClassDTO(CharacterClass characterClass) {
		this.name = characterClass.getName().toString();
		this.attributes = characterClass.getAttributes();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CharacterAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(CharacterAttributes attributes) {
		this.attributes = attributes;
	}
}
