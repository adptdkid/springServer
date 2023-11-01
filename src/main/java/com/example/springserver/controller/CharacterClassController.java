package com.example.springserver.controller;

import com.example.springserver.data.CharacterClassRepository;
import com.example.springserver.data.model.CharacterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class")
public class CharacterClassController {

    @Autowired
    private CharacterClassRepository characterClassRepository;
    private static final Logger logger = LoggerFactory.getLogger(CharacterController.class);

    @GetMapping
    public List<CharacterClass> getAllCharacters(){
        logger.info("Getting all current class list");
        return characterClassRepository.findAll();
    }

    @PostMapping("/create")
    public  CharacterClass createCharacter(@RequestBody  CharacterClass race) {
        logger.info("Adding new class: " + race.getClassName());
        return characterClassRepository.save(race);
    }

    @PutMapping("/update/{id}")
    public String updateRace(@PathVariable Long id,
                             @RequestParam(value = "name", required = true) String name) {
        try {
            characterClassRepository.getReferenceById(id).setClassName(name);
            return "Class created successfully";
        } catch (Exception ex) {
            logger.error("Error while trying to update class : " + ex);
            return "Something wrong";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRace(@PathVariable Long id) {
        try {
            characterClassRepository.deleteById(id);
            return "Class deleted successfully";
        } catch (Exception ex) {
            logger.error("Error while trying to delete class : " + ex);
            return "Something wrong! There is no class w this id";
        }

    }

}
