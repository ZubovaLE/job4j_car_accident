package ru.job4j.accident.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Accident {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String text;
    private String address;
    private AccidentType type;
    private Set<Rule> rules;

    public Accident(String name, String text, String address) {
        this.name = name;
        this.text = text;
        this.address = address;
    }
}