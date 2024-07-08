package com.sapient.sapient.hof;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HoFController {
    @Autowired
    HoFRepository hoFRepository;

    @GetMapping("/halloffame")
    public String home() {
        return "index";
    }

    @GetMapping("/hofdata")
    public String getAll(Model model) {
        model.addAttribute("halloffame", hoFRepository.findAll());
        return "halloffame";
    }

}
