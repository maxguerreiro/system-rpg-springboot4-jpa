package com.systemrpg.rpg.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systemrpg.rpg.entities.Attributes;
import com.systemrpg.rpg.entities.CharacterClass;

/**
 * REST API controller that handles HTTP requests related to character classes. 
 */
@RestController
@RequestMapping("/characterclasses")
public class CharacterClassResource {
	
	/** 
	 * Fetches all character classes.
	 * @return A list of all classes with an HTTP status (200)
	 */
	@GetMapping
	public ResponseEntity<List<CharacterClass>> findAll() {
		List<CharacterClass> list = new ArrayList<>();
		Attributes attributes = new Attributes(10, 5, 5, 5, 5, 5);
		CharacterClass cc = new CharacterClass(1L, "Warrior", attributes);
		list.add(cc);
		return ResponseEntity.ok().body(list);
	}
}