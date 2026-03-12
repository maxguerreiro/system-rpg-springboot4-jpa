package com.systemrpg.rpg.dtos;

import java.io.Serializable;

import com.systemrpg.rpg.entities.Attributes;
import com.systemrpg.rpg.entities.CharacterClass;

public class CharacterClassDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Attributes attributes;
	
	public CharacterClassDTO() {
	}

	public CharacterClassDTO(String name, Attributes attributes) {
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

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
}
