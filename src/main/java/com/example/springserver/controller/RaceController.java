package com.example.springserver.controller;

import com.example.springserver.data.RaceRepository;
import com.example.springserver.data.model.Race;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/race")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;
    private static final Logger logger = LoggerFactory.getLogger(CharacterController.class);

    @GetMapping
    public List<Race> getAllCharacters(){
        logger.info("Getting all current race list");
        return raceRepository.findAll();
    }

    @PostMapping("/create")
    public Race createCharacter(@RequestBody Race race) {
        logger.info("Adding new race: " + race.getRaceName());
        return raceRepository.save(race);
    }

    @PutMapping("/update/{id}")
    public String updateRace(@PathVariable Long id,
                             @RequestParam(value = "name", required = true) String name) {
        try {
            raceRepository.getReferenceById(id).setRaceName(name);
            return "Race created successfully";
        } catch (Exception ex) {
            logger.error("Error while trying to update race : " + ex);
            return "Something wrong!";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRace(@PathVariable Long id) {
        try {
            raceRepository.deleteById(id);
            return "Race deleted successfully";
        } catch (Exception ex) {
            logger.error("Error while trying to delete race : " + ex);
            return "Something wrong! There is no race w this id";
        }
    }
}
