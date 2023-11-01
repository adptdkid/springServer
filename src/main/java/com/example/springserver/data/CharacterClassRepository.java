package com.example.springserver.data;

import com.example.springserver.data.model.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterClassRepository  extends JpaRepository<CharacterClass, Long> {
}
