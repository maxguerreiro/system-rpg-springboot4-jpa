package com.systemrpg.rpg.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systemrpg.rpg.entities.RpgCharacter;
import com.systemrpg.rpg.services.RpgCharacterService;

/**
 * REST API controller that handles HTTP requests related to character classes. 
 */
@RestController
@RequestMapping("/characters")
public class RpgCharacterResource {
	
	@Autowired
	private RpgCharacterService characterService;
	
	/** 
	 * Fetches all character.
	 * @return A list of all character with an HTTP status (200)
	 */
	@GetMapping
	public ResponseEntity<List<RpgCharacter>> findAll() {
		List<RpgCharacter> list = characterService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/**
	 * Fetches a character class by its unique identifier.
	 * @param id The ID of the class to be retrieved.
	 * @return A ResponseEntity containing the CharacterClass object.
	 */
	@GetMapping(value = ("/{id}"))
	public ResponseEntity<RpgCharacter> findById(@PathVariable Long id) {
		RpgCharacter obj = characterService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}