package ru.job4j.accident.service;

import java.util.Collection;
import java.util.Optional;

public interface FindableForServices<E> {
    Collection<E> findAll();

    Optional<E> findById(int id);
}