package ru.job4j.accident.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;

@Getter
@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        accidents.put(1, new Accident("One", "Bad", "1, Example Street"));
        accidents.put(2, new Accident("Two", "Car accident", "2, Example Street"));
        accidents.put(3, new Accident("Three", "Car is broken", "3, Example Street"));
    }

    public void create(Accident accident) {
        accidents.put(accident.getId(), accident);
    }
}
