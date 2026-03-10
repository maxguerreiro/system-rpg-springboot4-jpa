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
		
		Attributes warriorAtributes = new Attributes();
		warriorAtributes.setHp(5);
		warriorAtributes.setStrength(10);
		
		Attributes sorcererAtributes = new Attributes();
		sorcererAtributes.setHp(8);
		sorcererAtributes.setMana(7);
		
		CharacterClass warrior = new CharacterClass(null, "Warrior", warriorAtributes);
		CharacterClass sorcerer = new CharacterClass(null, "Sorcerer", sorcererAtributes);
		
		classRepo.saveAll(Arrays.asList(warrior, sorcerer));
		
		RpgCharacter c1 = new RpgCharacter(null, "Gerald", 60, sorcerer);
		RpgCharacter c2 = new RpgCharacter(null, "Letho", 100, warrior);
		
		characterRepo.saveAll(Arrays.asList(c1, c2));
	}
	
	

}
