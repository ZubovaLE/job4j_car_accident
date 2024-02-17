package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Map;
import java.util.Optional;

@Service
public class AccidentService {
    private final AccidentMem accidentMem = new AccidentMem();

    private static final class Lazy {
        private static final AccidentService INST = new AccidentService();
    }

    public static AccidentService instOf() {
        return AccidentService.Lazy.INST;
    }

    public void create(Accident accident) {
        accidentMem.create(accident);
    }

    public Map<Integer, Accident> findAll() {
        return accidentMem.findAll();
    }

    public Optional<Accident> findById(int id) {
        return accidentMem.findById(id);
    }
}