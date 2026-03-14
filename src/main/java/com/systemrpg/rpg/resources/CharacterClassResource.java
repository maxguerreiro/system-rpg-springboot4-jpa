package com.systemrpg.rpg.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systemrpg.rpg.dtos.CharacterClassDTO;
import com.systemrpg.rpg.services.CharacterClassService;

/**
 * REST API controller that handles HTTP requests related to character classes. 
 */
@RestController
@RequestMapping("/characterclasses")
public class CharacterClassResource {
	
	@Autowired
	private CharacterClassService classService;
	
	/** 
	 * Fetches all character classes.
	 * @return A list of all classes with an HTTP status (200)
	 */
	@GetMapping
	public ResponseEntity<List<CharacterClassDTO>> findAll() {
		List<CharacterClassDTO> list = classService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/**
	 * Fetches a character class by its unique identifier.
	 * @param id The ID of the class to be retrieved.
	 * @return A ResponseEntity containing the CharacterClassDTO object.
	 */
	@GetMapping(value = ("/{id}"))
	public ResponseEntity<CharacterClassDTO> findById(@PathVariable Long id) {
		CharacterClassDTO obj = classService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}