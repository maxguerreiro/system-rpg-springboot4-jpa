package com.systemrpg.rpg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.systemrpg.rpg.entities.RpgCharacter;

public interface RpgCharacterRepository extends JpaRepository<RpgCharacter, Long>{

}
