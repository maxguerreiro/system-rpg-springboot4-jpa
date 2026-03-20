package com.systemrpg.rpg.dtos;

import java.io.Serializable;

import com.systemrpg.rpg.entities.CharacterAttributes;
import com.systemrpg.rpg.entities.CharacterClass;
import com.systemrpg.rpg.entities.RpgCharacter;

public class RpgCharacterDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Integer age;
	private CharacterAttributes attributes;
	private String characterClass;
	
	//---------
	
	private Integer xp;
	private Integer pts;
	private Integer level;
	
	public RpgCharacterDTO() {
	}

	public RpgCharacterDTO(Long id, String name, Integer age, CharacterAttributes attributes, CharacterClass characterClass) {
		super();
		this.setId(id);
		this.name = name;
		this.age = age;
		this.attributes = attributes;
		this.characterClass = characterClass.getName().toString();
	}
	
	public RpgCharacterDTO(RpgCharacter character) {
		this.setId(character.getId());
		this.name = character.getName();
		this.age = character.getAge();
		this.attributes = character.getBaseAttributes();
		this.characterClass = character.getCharacterClass().getName().toString();
		this.setXp(character.getXp());
		this.pts = character.getPts();
		this.level = character.getLevel();
	}

	public Integer getPts() {
		return pts;
	}

	public void setPts(Integer pts) {
		this.pts = pts;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public CharacterAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(CharacterAttributes attributes) {
		this.attributes = attributes;
	}

	public String getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getXp() {
		return xp;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
	}
}
