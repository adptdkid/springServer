package com.example.springserver.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "race_id")
    private Integer id;

    @Column(name = "race_name")
    private String raceName;


    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "race_id")
    private Set<Character> characters;

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public Integer getId() {
        return id;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }
}
