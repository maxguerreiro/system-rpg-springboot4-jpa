package com.systemrpg.rpg.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


/**
 * Represents a playable character in the game.
 * 
 * A Character has basic personal information such as name and age,
 * as well as base attributes (HP, strength, dexterity, etc.).
 * Each character is associated with a CharacterClass that can
 * modify or provide bonus attributes to the base attributes.
 */

@Entity
public class RpgCharacter implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer age;
	
	@Embedded
	private Attributes baseAttributes;
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	private CharacterClass characterClass;

	public RpgCharacter() {
	}

	public RpgCharacter(Long id, String name, Integer age, CharacterClass characterClass) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.baseAttributes = new Attributes();
		initialAttributes();
		this.characterClass = characterClass;
		bonusClass();
	}
	
	/**
	 * Initializes the default base attributes for a newly created character.
	 * 
	 * This method sets the starting values for HP, strength, dexterity,
	 * intelligence, resistance, and mana before any class bonuses are applied.
	 */
	private void initialAttributes() {
		baseAttributes.setHp(10);
		baseAttributes.setStrength(5);
		baseAttributes.setDexterity(5);
		baseAttributes.setIntelligence(5);
		baseAttributes.setResistance(5);
		baseAttributes.setMana(5);
	}
	
	/**
	 * Applies the attribute bonuses from the character's class.
	 * 
	 * The attributes defined in the CharacterClass are added to the
	 * character's base attributes.
	 */
	public void bonusClass() {
		baseAttributes.addAttributes(characterClass.getAttributes());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setAge(Integer age) {
		this.age = age;
	}

	public Attributes getBaseAttributes() {
		return baseAttributes;
	}

	public void setBaseAttributes(Attributes baseAttributes) {
		this.baseAttributes = baseAttributes;
	}

	public CharacterClass getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(CharacterClass characterClass) {
		this.characterClass = characterClass;
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
		RpgCharacter other = (RpgCharacter) obj;
		return Objects.equals(id, other.id);
	}
}
