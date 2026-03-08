package com.systemrpg.rpg.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.systemrpg.rpg.entities.Attributes;
import com.systemrpg.rpg.entities.CharacterClass;
import com.systemrpg.rpg.repositories.CharacterClassRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner{
	
	@Autowired
	private CharacterClassRepository classRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Attributes warriorAtributes = new Attributes(null, 10, 5, null, 5, null);
		Attributes sorcererAtributes = new Attributes(6, null, null, 5, null, 9);
		
		CharacterClass warrior = new CharacterClass(null, "Warrior", warriorAtributes);
		CharacterClass sorcerer = new CharacterClass(null, "Sorcerer", sorcererAtributes);
		
		classRepo.saveAll(Arrays.asList(warrior, sorcerer));
		
	}
	
	

}
