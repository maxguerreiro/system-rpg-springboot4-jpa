package com.systemrpg.rpg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemrpg.rpg.dtos.CharacterClassDTO;
import com.systemrpg.rpg.entities.CharacterClass;
import com.systemrpg.rpg.repositories.CharacterClassRepository;
import com.systemrpg.rpg.services.exceptions.ResourceNotFoundException;

/**
 * Service class for managing character class operations.
 */
@Service
public class CharacterClassService {
	
	@Autowired
	private CharacterClassRepository classRepo;
	
	/**
	 * Retrieves all characters classes from the database and converts them into DTO objects.
	 *
	 * This method fetches all persisted CharacterClass entities and maps them to
	 * CharacterClassDTO instances before returning the result. The DTO layer is used
	 * to expose only the necessary data to the API consumers while hiding the
	 * internal entity structure.
	 *
	 * @return a list of CharacterClassDTO objects representing all characters
	 */
	public List<CharacterClassDTO> findAll() {
		List<CharacterClass> list = classRepo.findAll();
		return list.stream()
				.map(CharacterClassDTO::new)
				.toList();
	}
	
	/**
	 * Retrieves a single character class by its identifier.
	 *
	 * This method searches the database for a character class with the given ID.
	 * If found, the entity is converted into a CharacterClassDTO before being returned.
	 *
	 * @param id the unique identifier of the character
	 * @return a RpgCharacterDTO representing the found character
	 * @throws RuntimeException if the character does not exist
	 */
	public CharacterClassDTO findById(Long id) {
		CharacterClass obj = classRepo.findById(id) 
				.orElseThrow(() -> new ResourceNotFoundException(id));
		return new CharacterClassDTO(obj);
	}

}