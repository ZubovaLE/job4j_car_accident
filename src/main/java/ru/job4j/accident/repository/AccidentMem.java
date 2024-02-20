package ru.job4j.accident.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class AccidentMem implements Findable<Accident> {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    public void create(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    @Override
    public List<Accident> findAll() {
        return accidents.values().stream().toList();
    }

    @Override
    public Optional<Accident> findById(int id) {
        return Optional.of(accidents.get(id));
    }
}
