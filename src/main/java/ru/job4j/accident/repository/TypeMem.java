package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class TypeMem implements Findable<AccidentType> {
    private final HashMap<Integer, AccidentType> types = new HashMap<>();

    public TypeMem() {
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
    }

    @Override
    public List<AccidentType> findAll() {
        return types.values().stream().toList();
    }

    @Override
    public Optional<AccidentType> findById(int id) {
        return Optional.of(types.get(id));
    }
}