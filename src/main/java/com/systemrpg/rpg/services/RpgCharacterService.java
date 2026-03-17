package com.systemrpg.rpg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemrpg.rpg.dtos.CharacterAttributesUpdateDTO;
import com.systemrpg.rpg.dtos.RpgCharacterDTO;
import com.systemrpg.rpg.entities.CharacterClass;
import com.systemrpg.rpg.entities.RpgCharacter;
import com.systemrpg.rpg.enums.ClassType;
import com.systemrpg.rpg.repositories.CharacterClassRepository;
import com.systemrpg.rpg.repositories.RpgCharacterRepository;
import com.systemrpg.rpg.services.exceptions.ResourceNotFoundException;

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
	 * Retrieves a character by its identifier.
	 *
	 * If no character is found with the given ID, a ResourceNotFoundException is thrown.
	 *
	 *
	 * @param id Identifier of the character
	 * @return RpgCharacterDTO containing the character data
	 * @throws ResourceNotFoundException if the character does not exist
	 */
	public RpgCharacterDTO findById(Long id) {

	    RpgCharacter obj = characterRepo.findById(id)
	    		.orElseThrow(() -> new ResourceNotFoundException(id));

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
	
	public void deleteById(Long id) {
		characterRepo.deleteById(id);
	}
	
	/**
	 * Updates the attributes of a character.
	 *
	 * This method retrieves the character by its ID, updates only the attributes
	 * provided in the DTO, and persists the changes in the database.
	 *
	 * @param id the ID of the character to update
	 * @param dto the DTO containing the new attribute values
	 * @return a DTO representing the updated character
	 * @throws ResourceNotFoundException if the character does not exist
	 */
	public RpgCharacterDTO updateAttributes(Long id, CharacterAttributesUpdateDTO attributes) {
		RpgCharacter obj = characterRepo.getReferenceById(id);
		obj.getBaseAttributes().addAttributes(attributes);
		RpgCharacterDTO dto = new RpgCharacterDTO(obj);
		characterRepo.save(obj);
		return dto;
	}
}