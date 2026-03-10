package com.systemrpg.rpg.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

/*
 * Base attributes container for game entities
 * Implements Serializable for data persistence or network transmission.
 */
@Embeddable
public class Attributes implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer hp = 0; 
	private Integer strength = 0;
	private Integer dexterity = 0;
	private Integer intelligence = 0;
	private Integer resistance = 0;
	private Integer mana = 0;
	
	public Attributes() {
		super();
	}

	public Attributes(Integer hp, Integer strength, Integer dexterity, Integer intelligence, Integer resistance,
			Integer mana) {
		super();
		this.hp = hp;
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.resistance = resistance;
		this.mana = mana;
	}
	
	/*
	 * Adds the values of the provided attributes to the current one 
	 */
	public void addAttributes(Attributes bonus) {
		this.hp += bonus.hp;
		this.strength += bonus.strength;
		this.dexterity += bonus.dexterity;
		this.intelligence += bonus.intelligence;
		this.resistance += bonus.resistance;
		this.mana += bonus.mana;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getResistance() {
		return resistance;
	}

	public void setResistance(Integer resistance) {
		this.resistance = resistance;
	}

	public Integer getMana() {
		return mana;
	}

	public void setMana(Integer mana) {
		this.mana = mana;
	}
}