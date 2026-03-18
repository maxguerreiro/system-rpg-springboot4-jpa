package com.systemrpg.rpg.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.systemrpg.rpg.entities.CharacterAttributes;
import com.systemrpg.rpg.entities.CharacterClass;
import com.systemrpg.rpg.repositories.CharacterClassRepository;
import com.systemrpg.rpg.repositories.RpgCharacterRepository;
import com.systemrpg.rpg.entities.RpgCharacter;
import com.systemrpg.rpg.enums.ClassType;

/**
 * Test configuration class used to seed the database 
 * with initial data when the 'test' profile is active.
 */
@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner{
	
	@Autowired
	private CharacterClassRepository classRepo;
	
	@Autowired
	private RpgCharacterRepository characterRepo;

	@Override
	public void run(String... args) throws Exception {
		
		CharacterClass warrior = new CharacterClass();
		warrior.setName(ClassType.WARRIOR);

		CharacterAttributes warriorAttr = new CharacterAttributes();
		warriorAttr.setHp(8);
		warriorAttr.setStrength(9);
		warriorAttr.setDexterity(3);
		warriorAttr.setIntelligence(1);
		warriorAttr.setResistance(7);
		warriorAttr.setMana(0);
		warrior.setAttributes(warriorAttr);

		// ----------------------------

		CharacterClass mage = new CharacterClass();
		mage.setName(ClassType.MAGE);

		CharacterAttributes mageAttr = new CharacterAttributes();
		mageAttr.setHp(3);
		mageAttr.setStrength(1);
		mageAttr.setDexterity(3);
		mageAttr.setIntelligence(10);
		mageAttr.setResistance(2);
		mageAttr.setMana(12);
		mage.setAttributes(mageAttr);

		// ----------------------------

		CharacterClass rogue = new CharacterClass();
		rogue.setName(ClassType.ROGUE);

		CharacterAttributes rogueAttr = new CharacterAttributes();
		rogueAttr.setHp(5);
		rogueAttr.setStrength(4);
		rogueAttr.setDexterity(10);
		rogueAttr.setIntelligence(3);
		rogueAttr.setResistance(3);
		rogueAttr.setMana(2);
		rogue.setAttributes(rogueAttr);

		// ----------------------------

		CharacterClass archer = new CharacterClass();
		archer.setName(ClassType.ARCHER);

		CharacterAttributes archerAttr = new CharacterAttributes();
		archerAttr.setHp(5);
		archerAttr.setStrength(5);
		archerAttr.setDexterity(8);
		archerAttr.setIntelligence(3);
		archerAttr.setResistance(3);
		archerAttr.setMana(1);
		archer.setAttributes(archerAttr);

		// ----------------------------

		CharacterClass paladin = new CharacterClass();
		paladin.setName(ClassType.PALADIN);

		CharacterAttributes paladinAttr = new CharacterAttributes();
		paladinAttr.setHp(9);
		paladinAttr.setStrength(7);
		paladinAttr.setDexterity(2);
		paladinAttr.setIntelligence(4);
		paladinAttr.setResistance(8);
		paladinAttr.setMana(5);
		paladin.setAttributes(paladinAttr);

		// save all class characters
		classRepo.saveAll(Arrays.asList(warrior, mage, rogue, archer, paladin));
		
		RpgCharacter c1 = new RpgCharacter(null, "Tharok", 45, warrior);
		RpgCharacter c2 = new RpgCharacter(null, "Elyra", 120, mage);
		RpgCharacter c3 = new RpgCharacter(null, "Kael", 28, rogue);
		RpgCharacter c4 = new RpgCharacter(null, "Lyria", 34, archer);
		RpgCharacter c5 = new RpgCharacter(null, "Thorfin", 52, paladin);
		
		characterRepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
	}
	
	

}
