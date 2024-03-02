package ru.job4j.accident.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.service.AccidentService;

@RequiredArgsConstructor
@Controller
public class IndexControl {
    private final AccidentService accidentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }
}