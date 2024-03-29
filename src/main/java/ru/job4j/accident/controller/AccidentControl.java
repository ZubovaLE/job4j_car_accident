package ru.job4j.accident.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.RuleService;
import ru.job4j.accident.service.TypeService;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class AccidentControl {
    private final AccidentService accidentService;
    private final TypeService typeService;
    private final RuleService ruleService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("rules", ruleService.findAll());
        return "accident/create";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        Accident accident = accidentService.findById(id).get();
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("rules", ruleService.findAll());
        model.addAttribute("selectedRules", accident.getRules());
        model.addAttribute("accident", accident);
        return "accident/update";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest request) {
        accident.setType(typeService.findById(accident.getType().getId()).get());
        String[] ids = request.getParameterValues("rIds");
        accident.setRules(ruleService.findByIdArray(ids));
        accidentService.save(accident);
        return "redirect:/";
    }
}