package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.TypeService;

@Controller
public class AccidentControl {
    private final AccidentService accidentService = AccidentService.instOf();
    private final TypeService typeService = TypeService.instOf();


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", typeService.findAll());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        accident.setType(typeService.findById(accident.getType().getId()));
        accidentService.create(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("accident", accidentService.findById(id).get());
        return "accident/update";
    }
}