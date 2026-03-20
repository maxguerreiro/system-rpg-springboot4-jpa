package com.systemrpg.rpg.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.systemrpg.rpg.dtos.CharacterAttributesUpdateDTO;
import com.systemrpg.rpg.dtos.GainPointsDTO;
import com.systemrpg.rpg.dtos.GainXpDTO;
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
	
	/**
	 * Creates a new RPG character.
	 *
	 * This endpoint receives character data in the request body and delegates
	 * the creation process to the service layer. After the character is created,
	 * it builds the URI for the newly created resource and returns it in the
	 * Location header following REST best practices.
	 *
	 * @param dto the DTO containing the character creation data
	 * @return a ResponseEntity containing the created RpgCharacterDTO
	 *         with HTTP status 201 (Created) and the URI of the new resource
	 *         in the Location header
	 */
	@PostMapping
	public ResponseEntity<RpgCharacterDTO> newCharacter(@RequestBody RpgCharacterDTO dto) {
		RpgCharacterDTO newCharacter = characterService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCharacter.getId()).toUri();
		return ResponseEntity.created(uri).body(newCharacter);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		characterService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Updates the attributes of an existing RPG character.
	 *
	 * This endpoint receives a partial set of character attributes in the request body
	 * and updates the corresponding attributes of the character identified by the
	 * provided ID. Only the attributes present in the request will be updated.
	 *
	 * @param id the ID of the character whose attributes will be updated
	 * @param attributesDTO the DTO containing the attributes to update
	 * @return a ResponseEntity containing the updated RpgCharacterDTO
	 *         with HTTP status 200 (OK)
	 */
	@PutMapping("/{id}")
	public ResponseEntity<RpgCharacterDTO> updateAttributes(
	        @PathVariable Long id,
	        @RequestBody CharacterAttributesUpdateDTO attributesDTO) {

	    RpgCharacterDTO dto = characterService.updateAttributes(id, attributesDTO);
	    return ResponseEntity.ok().body(dto);
	}
	
	/**
	 * Grants experience points to a character.
	 *
	 * This endpoint receives an amount of XP in the request body and adds it to
	 * the character identified by the given ID. If the accumulated XP reaches
	 * the required threshold, the character levels up automatically and gains
	 * attribute points accordingly.
	 *
	 * @param id the ID of the character
	 * @param dto the DTO containing the amount of XP to be added
	 * @return a ResponseEntity containing the updated RpgCharacterDTO
	 *         with HTTP status 200 (OK)
	 */
	@PatchMapping("/{id}/gain-xp")
	public ResponseEntity<RpgCharacterDTO> gainXp(@PathVariable Long id, @RequestBody GainXpDTO amount) {
		RpgCharacterDTO dto = characterService.gainXp(id, amount.getAmount());
		return ResponseEntity.ok().body(dto);
	}
	
	/**
	 * Grants attribute points directly to a character.
	 *
	 * This endpoint is typically used for rewards such as quests or events,
	 * allowing the character to receive attribute points without leveling up.
	 *
	 * @param id the ID of the character
	 * @param dto the DTO containing the amount of points to be added
	 * @return a ResponseEntity containing the updated RpgCharacterDTO
	 *         with HTTP status 200 (OK)
	 */
	@PatchMapping("/{id}/gain-points") 
	public ResponseEntity<RpgCharacterDTO> gainPoints(@PathVariable Long id, @RequestBody GainPointsDTO amount) {
		RpgCharacterDTO dto = characterService.gainPoints(id, amount.getAmount());
		
		return ResponseEntity.ok().body(dto);
	}

}