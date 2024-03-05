package ru.job4j.accident.repository;

import lombok.RequiredArgsConstructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.job4j.accident.model.Accident;

import java.util.List;

@RequiredArgsConstructor
public class AccidentHibernate {
    private final SessionFactory sf;

    public Accident save(Accident accident) {
        try (Session session = sf.openSession()) {
            session.save(accident);
            return accident;
        }
    }

    public List<Accident> findAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident", Accident.class)
                    .list();
        }
    }
}
