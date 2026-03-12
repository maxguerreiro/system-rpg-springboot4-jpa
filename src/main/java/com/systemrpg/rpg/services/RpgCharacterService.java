package com.systemrpg.rpg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemrpg.rpg.dtos.RpgCharacterDTO;
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
	 * Retrieves all RPG characters from the database and converts them into DTO objects.
	 *
	 * This method fetches all persisted RpgCharacter entities and maps them to
	 * RpgCharacterDTO instances before returning the result. The DTO layer is used
	 * to expose only the necessary data to the API consumers while hiding the
	 * internal entity structure.
	 *
	 * @return a list of RpgCharacterDTO objects representing all characters
	 */
	public List<RpgCharacterDTO> findAll() {
		List<RpgCharacter> list = characterRepo.findAll();
		
		return list.stream()
				.map(RpgCharacterDTO::new)
				.toList();
	}
	
	/**
	 * Retrieves a single RPG character by its identifier.
	 *
	 * This method searches the database for a character with the given ID.
	 * If found, the entity is converted into a RpgCharacterDTO before being returned.
	 *
	 * @param id the unique identifier of the character
	 * @return a RpgCharacterDTO representing the found character
	 * @throws RuntimeException if the character does not exist
	 */
	public RpgCharacterDTO findById(Long id) {

	    RpgCharacter obj = characterRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Character not found"));

	    return new RpgCharacterDTO(obj);
	}

}