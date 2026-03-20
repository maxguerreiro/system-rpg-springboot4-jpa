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
import com.systemrpg.rpg.services.exceptions.InvalidClassCharacterException;
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
	 * This method validates the provided character class, converting it into a
	 * ClassType enum and retrieving the corresponding CharacterClass entity.
	 * If the class is invalid or not found, an exception is thrown.
	 *
	 * After validation, a new RpgCharacter entity is created, saved in the database,
	 * and returned as a DTO.
	 *
	 * @param dto the data transfer object containing character creation data
	 * @return a RpgCharacterDTO representing the newly created character
	 * @throws InvalidClassCharacterException if the provided class is invalid or does not exist
	 */
	public RpgCharacterDTO insert(RpgCharacterDTO dto) {
		
		ClassType type;
		
		try {
			type = ClassType.fromString(dto.getCharacterClass());
		} catch (IllegalArgumentException e) {
			throw new InvalidClassCharacterException(dto.getCharacterClass());
		}
		
		
		CharacterClass characterClass = classRepo.findByName(type)
				.orElseThrow(() -> new InvalidClassCharacterException(dto.getCharacterClass()));
		
		RpgCharacter obj = new RpgCharacter(null, dto.getName(), dto.getAge(), characterClass);
		
		obj = characterRepo.save(obj);
		
		return new RpgCharacterDTO(obj);
	}
	
	/**
	 * Deletes a character by its identifier.
	 *
	 * This method first checks whether the character exists in the database.
	 * If no entity is found, a ResourceNotFoundException is thrown.
	 *
	 * @param id identifier of the character to be deleted
	 * @throws ResourceNotFoundException if the character does not exist
	 */
	public void deleteById(Long id) {
		if (!characterRepo.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
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
	
	/**
	 * Adds experience points to a character and handles automatic level progression.
	 *
	 * This method retrieves the character by its ID, increases its XP based on the
	 * provided amount, and checks if the character qualifies for one or more level-ups.
	 * When leveling up, the character gains attribute points accordingly.
	 *
	 * @param id the ID of the character
	 * @param amount the amount of XP to add
	 * @return a DTO representing the updated character
	 * @throws ResourceNotFoundException if the character does not exist
	 */
	public RpgCharacterDTO gainXp(Long id, Integer amount) {
		
		RpgCharacter obj = characterRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
		
		obj.gainXp(amount);
		
		characterRepo.save(obj);
		
		return new RpgCharacterDTO(obj);
	}
	
	/**
	 * Adds attribute points directly to a character.
	 *
	 * This method is used to grant points independently of the leveling system,
	 * typically as a reward mechanism. The points are added to the character's
	 * available pool for attribute distribution.
	 *
	 * @param id the ID of the character
	 * @param points the number of points to add
	 * @return a DTO representing the updated character
	 * @throws ResourceNotFoundException if the character does not exist
	 */
	public RpgCharacterDTO gainPoints(Long id, Integer amount) {
		
		RpgCharacter obj = characterRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
		
		obj.setPts(obj.getPts() + amount);
		
		characterRepo.save(obj);
		
		return new RpgCharacterDTO(obj);
	}
}