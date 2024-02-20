package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.RuleMem;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RuleService implements FindableForServices<Rule> {
    private final RuleMem ruleMem = new RuleMem();

    private static final class Lazy {
        private static final RuleService INST = new RuleService();
    }

    public static RuleService instOf() {
        return RuleService.Lazy.INST;
    }

    @Override
    public Set<Rule> findAll() {
        return ruleMem.findAll();
    }

    @Override
    public Optional<Rule> findById(int id) {
        return ruleMem.findById(id);
    }

    public Set<Rule> findByIdArray(String[] ids) {
        Set<Rule> result = new HashSet<>();
        for (String id : ids) {
            Optional<Rule> rule = ruleMem.findById(Integer.parseInt(id));
            rule.ifPresent(result::add);
        }
        return result;
    }
}