package com.example.springserver.data;

import com.example.springserver.data.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CharacterRepository extends JpaRepository<Character, Long> {

}
