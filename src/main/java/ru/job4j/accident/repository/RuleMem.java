package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.*;

@Repository
public class RuleMem implements Findable<Rule> {
    private final Map<Integer, Rule> rules = new HashMap<>();

    public RuleMem() {
        Rule one = Rule.of(1, "Rule one");
        Rule two = Rule.of(2, "Rule two");
        Rule three = Rule.of(3, "Rule three");
        rules.put(one.getId(), one);
        rules.put(two.getId(), two);
        rules.put(three.getId(), three);
    }

    @Override
    public Set<Rule> findAll() {
        return new HashSet<>(rules.values());
    }

    @Override
    public Optional<Rule> findById(int id) {
        return Optional.of(rules.get(id));
    }
}