package ru.job4j.accident.repository;

import ru.job4j.accident.model.Accident;

import java.util.Map;
import java.util.Optional;

public interface Findable<E> {
    Map<Integer, Accident> findAll();

    Optional<E> findById(int id);
}
