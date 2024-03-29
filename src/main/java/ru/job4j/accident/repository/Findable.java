package ru.job4j.accident.repository;

import java.util.Collection;
import java.util.Optional;

public interface Findable<E> {
    Collection<E> findAll();

    Optional<E> findById(int id);
}