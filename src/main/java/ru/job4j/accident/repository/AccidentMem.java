package ru.job4j.accident.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
@Repository
public class AccidentMem implements Findable<Accident> {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    public void create(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    @Override
    public Map<Integer, Accident> findAll() {
        return accidents;
    }

    @Override
    public Optional<Accident> findById(int id) {
        return Optional.of(accidents.get(id));
    }
}
