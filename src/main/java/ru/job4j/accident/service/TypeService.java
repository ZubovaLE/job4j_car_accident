package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.TypeMem;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService implements FindableForServices<AccidentType> {
    private final TypeMem typeMem = new TypeMem();

    private static final class Lazy {
        private static final TypeService INST = new TypeService();
    }

    public static TypeService instOf() {
        return TypeService.Lazy.INST;
    }

    public List<AccidentType> findAll() {
        return typeMem.findAll();
    }

    public Optional<AccidentType> findById(int id) {
        return typeMem.findById(id);
    }
}