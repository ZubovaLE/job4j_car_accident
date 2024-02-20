package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.List;
import java.util.Optional;

@Service
public class AccidentService implements FindableForServices<Accident> {
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

    @Override
    public List<Accident> findAll() {
        return accidentMem.findAll();
    }

    @Override
    public Optional<Accident> findById(int id) {
        return accidentMem.findById(id);
    }
}