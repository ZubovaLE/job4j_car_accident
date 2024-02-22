package ru.job4j.accident.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import ru.job4j.accident.service.AccidentService;

@Controller
public class IndexControl {
    private final AccidentService accidentService = new AccidentService(new AccidentJdbcTemplate(new JdbcTemplate()));

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }
}