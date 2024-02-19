package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.HashMap;
import java.util.List;

@Repository
public class TypeMem {
    private final HashMap<Integer, AccidentType> types = new HashMap<>();

    public TypeMem() {
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
    }

    public List<AccidentType> findAll() {
        return types.values().stream().toList();
    }

    public AccidentType findById(int id) {
        return types.get(id);
    }
}