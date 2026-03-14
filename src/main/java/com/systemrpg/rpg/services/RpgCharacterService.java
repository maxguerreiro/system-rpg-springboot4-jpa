package com.systemrpg.rpg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemrpg.rpg.dtos.RpgCharacterDTO;
import com.systemrpg.rpg.entities.CharacterClass;
import com.systemrpg.rpg.entities.RpgCharacter;
import com.systemrpg.rpg.enums.ClassType;
import com.systemrpg.rpg.repositories.CharacterClassRepository;
import com.systemrpg.rpg.repositories.RpgCharacterRepository;

/**
 * Service class for managing character class operations.
 */
@Service
public class RpgCharacterService {
	
	@Autowired
	private RpgCharacterRepository characterRepo;
	
	@Autowired
	private CharacterClassRepository classRepo;	
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
	
	/**
	 * Creates and persists a new RPG character based on the provided DTO.
	 *
	 * This method receives character data from the API layer, converts the
	 * provided class name into a ClassType enum, and retrieves the corresponding
	 * CharacterClass entity from the database.
	 *
	 * A new RpgCharacter entity is then created and saved in the database.
	 * After persistence, the entity is converted back into a DTO to be returned
	 * to the API client.
	 *
	 * @param dto the data transfer object containing the character creation data
	 * @return a RpgCharacterDTO representing the newly created character
	 * @throws RuntimeException if the provided class does not exist
	 */
	public RpgCharacterDTO insert(RpgCharacterDTO dto) {
		
		ClassType type = ClassType.fromString(dto.getCharacterClass());
		
		CharacterClass characterClass = classRepo.findByName(type)
				.orElseThrow(() -> new RuntimeException("Class not found"));
		
		RpgCharacter obj = new RpgCharacter(null, dto.getName(), dto.getAge(), characterClass);
		
		obj = characterRepo.save(obj);
		
		return new RpgCharacterDTO(obj);
	}

}