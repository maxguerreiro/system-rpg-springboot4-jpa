package com.systemrpg.rpg.dtos;

import java.io.Serializable;

import com.systemrpg.rpg.entities.Attributes;
import com.systemrpg.rpg.entities.CharacterClass;
import com.systemrpg.rpg.entities.RpgCharacter;

public class RpgCharacterDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer age;
	private Attributes attributes;
	private String characterClass;
	
	public RpgCharacterDTO() {
	}

	public RpgCharacterDTO(String name, Integer age, Attributes attributes, CharacterClass characterClass) {
		super();
		this.name = name;
		this.age = age;
		this.attributes = attributes;
		this.characterClass = characterClass.getName().toString();
	}
	
	public RpgCharacterDTO(RpgCharacter character) {
		this.name = character.getName();
		this.age = character.getAge();
		this.attributes = character.getBaseAttributes();
		this.characterClass = character.getCharacterClass().getName().toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer idade) {
		this.age = idade;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public String getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}
}
