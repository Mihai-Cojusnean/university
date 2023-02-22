package com.cojusnean.controllers;

import com.cojusnean.database.repository.CountryRepo;
import com.cojusnean.database.repository.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    private final PeopleRepo peopleRepo;
    private final CountryRepo countryRepo;

    @Autowired
    public MainController(PeopleRepo peopleRepo, CountryRepo countryRepo) {
        this.peopleRepo = peopleRepo;
        this.countryRepo = countryRepo;
    }

    @GetMapping
    public String main(Model model) {
        HashMap<Object, Object> data = new HashMap<>();
//        data.put("people", peopleRepo.findAll());
//        data.put("countries", countryRepo.findAll());

//        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", true);

        return "index";
    }
}
