package com.systemrpg.rpg.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.systemrpg.rpg.entities.Attributes;
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

		Attributes warriorAttr = new Attributes();
		warriorAttr.setHp(5);
		warriorAttr.setStrength(8);
		warriorAttr.setDexterity(2);
		warriorAttr.setIntelligence(1);
		warriorAttr.setResistance(6);
		warriorAttr.setMana(0);

		warrior.setAttributes(warriorAttr);
		
		CharacterClass mage = new CharacterClass();
		mage.setName(ClassType.MAGE);

		Attributes mageAttr = new Attributes();
		mageAttr.setHp(2);
		mageAttr.setStrength(1);
		mageAttr.setDexterity(3);
		mageAttr.setIntelligence(9);
		mageAttr.setResistance(2);
		mageAttr.setMana(10);

		mage.setAttributes(mageAttr);
		
		classRepo.saveAll(Arrays.asList(warrior, mage));
		
		RpgCharacter c1 = new RpgCharacter(null, "Personagem1", 60, mage);
		RpgCharacter c2 = new RpgCharacter(null, "Personagem2", 100, warrior);
		
		characterRepo.saveAll(Arrays.asList(c1, c2));
	}
	
	

}
