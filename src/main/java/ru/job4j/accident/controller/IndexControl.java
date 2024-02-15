package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexControl {
    @GetMapping("/")
    public String index(Model model) {
        List<String> info = List.of("Bob", "23", "engineer", "Example street 5");
        model.addAttribute("userInfo", info);
        return "index";
    }
}