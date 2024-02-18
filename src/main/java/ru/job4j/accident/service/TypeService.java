package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.TypeMem;

import java.util.List;

@Service
public class TypeService {
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
}