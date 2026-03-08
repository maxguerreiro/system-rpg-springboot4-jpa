package com.systemrpg.rpg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemrpg.rpg.entities.CharacterClass;
import com.systemrpg.rpg.repositories.CharacterClassRepository;

/**
 * Service class for managing character class operations.
 */
@Service
public class CharacterClassService {
	
	@Autowired
	private CharacterClassRepository classRepo;
	
	/**
	 * Returns a list of all character classes persisted in the database.
	 * @return List of CharacterClass entities.
	 */
	public List<CharacterClass> findAll() {
		return classRepo.findAll(); 
	}
	
	/**
	 * Returns a character classes persisted in the database, searching by id.
	 * @return List a CharacterClass entity.
	 */
	public CharacterClass findById(Long id) {
		Optional<CharacterClass> obj = classRepo.findById(id);
		return obj.get();
	}

}