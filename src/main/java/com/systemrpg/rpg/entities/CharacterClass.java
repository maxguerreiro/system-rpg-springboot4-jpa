package com.systemrpg.rpg.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.systemrpg.rpg.enums.ClassType;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


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

    @Enumerated(EnumType.STRING)
    private ClassType name;

    @Embedded
    private Attributes attributes;

    @OneToMany(mappedBy = "characterClass")
    private List<RpgCharacter> characters;
	
	public CharacterClass() {
	}

	public CharacterClass(Long id, ClassType name, Attributes bonusAttributes) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClassType getName() {
		return name;
	}

	public void setName(ClassType type) {
		this.name = type;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public List<RpgCharacter> getCharacters() {
		return characters;
	}

	public void setCharacters(List<RpgCharacter> characters) {
		this.characters = characters;
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