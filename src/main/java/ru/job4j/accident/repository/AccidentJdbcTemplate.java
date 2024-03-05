package ru.job4j.accident.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class AccidentJdbcTemplate implements Findable<Accident> {
    private final JdbcTemplate jdbc;

    public Accident save(Accident accident) {
        jdbc.update("insert into accident (name, text, address) values (?, ?, ?)",
                accident.getName(), accident.getText(), accident.getAddress());
        return accident;
    }

    @Override
    public List<Accident> findAll() {
        return jdbc.query("select id, name, text, address from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    return accident;
                });
    }

    @Override
    public Optional<Accident> findById(int id) {
        return Optional.ofNullable(jdbc.queryForObject("select * from accident where id = ?", Accident.class, id));
    }
}