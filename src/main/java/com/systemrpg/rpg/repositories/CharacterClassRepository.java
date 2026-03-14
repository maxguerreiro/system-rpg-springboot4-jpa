package com.systemrpg.rpg.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.systemrpg.rpg.entities.CharacterClass;
import com.systemrpg.rpg.enums.ClassType;

public interface CharacterClassRepository extends JpaRepository<CharacterClass, Long>{
	
	
	/**
	 * Retrieves a CharacterClass entity by its class type.
	 *
	 * @param name the class type to search for
	 * @return an Optional containing the CharacterClass if found
	 */
	Optional<CharacterClass> findByName(ClassType name);

}
