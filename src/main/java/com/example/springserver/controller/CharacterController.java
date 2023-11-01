package com.example.springserver.controller;

import com.example.springserver.data.CharacterRepository;
import com.example.springserver.data.model.Character;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;
    private static final Logger logger = LoggerFactory.getLogger(CharacterController.class);

    @GetMapping
    public List<Character> getAllCharacters(){
        logger.info("Getting all current characters list");
        return characterRepository.findAll();
    }

    @PostMapping("/create")
    public String createCharacter(@RequestBody Character character) {
        logger.info("Adding new character: " + character.getName());
        try {
            characterRepository.save(character);
            return "Character created successfully";
        } catch (Exception ex) {
            logger.error("Error while trying to create new character: " + ex);
            return "Something wrong!";
        }
    }

    @PutMapping("/update/{id}")
    public String updateCharacter(@PathVariable Long id,
                                  @RequestBody Character character) {
        logger.info("Update character");
        try {
            character.getCharacterClass().getId();
            character.getRace().getId();
            Character characterForUpdate = characterRepository.findById(id).get();
            characterForUpdate.setName(character.getName());
            characterForUpdate.setCharacterClass(character.getCharacterClass());
            characterForUpdate.setRace(character.getRace());
            characterRepository.save(characterForUpdate);
            return "Character updated successfully";
        } catch (Exception ex) {
            logger.error("Error while trying to update character: " + ex);
            return "Something wrong!";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCharacter(@PathVariable Long id) {
        logger.info("Trying to delete character w id : " + id);
        try {
            characterRepository.findById(id);
            characterRepository.deleteById(id);
            return "Character deleted successfully";
        } catch (Exception ex) {
            logger.error("Error while trying to delete character: " + ex);
            return "Something wrong! There is no character w this id";
        }
    }



}
