package com.systemrpg.rpg.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systemrpg.rpg.dtos.RpgCharacterDTO;
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
	public ResponseEntity<List<RpgCharacterDTO>> findAll() {
		List<RpgCharacterDTO> list = characterService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/**
	 * Retrieves a specific RPG character by its unique identifier.
	 *
	 * This endpoint returns the character data as a DTO representation,
	 * ensuring that only the necessary information is exposed to the client.
	 *
	 * @param id the unique identifier of the character
	 * @return a ResponseEntity containing the RpgCharacterDTO and HTTP status 200 (OK)
	 */
	@GetMapping(value = ("/{id}"))
	public ResponseEntity<RpgCharacterDTO> findById(@PathVariable Long id) {
		RpgCharacterDTO obj = characterService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}