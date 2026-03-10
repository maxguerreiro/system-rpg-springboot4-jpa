package com.systemrpg.rpg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemrpg.rpg.entities.RpgCharacter;
import com.systemrpg.rpg.repositories.RpgCharacterRepository;

/**
 * Service class for managing character class operations.
 */
@Service
public class RpgCharacterService {
	
	@Autowired
	private RpgCharacterRepository characterRepo;
	
	/**
	 * Returns a list of all character persisted in the database.
	 * @return List of Character entities.
	 */
	public List<RpgCharacter> findAll() {
		return characterRepo.findAll(); 
	}
	
	/**
	 * Returns a character persisted in the database, searching by id.
	 * @return List a Character entity.
	 */
	public RpgCharacter findById(Long id) {
		Optional<RpgCharacter> obj = characterRepo.findById(id);
		return obj.get();
	}

}