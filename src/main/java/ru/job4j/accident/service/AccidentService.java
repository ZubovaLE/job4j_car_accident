package ru.job4j.accident.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentJdbcTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccidentService implements FindableForServices<Accident> {
    private final AccidentJdbcTemplate accidents;

    public void create(Accident accident) {
        accidents.create(accident);
    }

    @Override
    public List<Accident> findAll() {
        return accidents.findAll();
    }

    @Override
    public Optional<Accident> findById(int id) {
        return accidents.findById(id);
    }
}