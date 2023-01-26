package com.cojusnean.controllers;

import com.cojusnean.database.entity.People;
import com.cojusnean.service.PeopleDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleDAO peopleDAO;

    public PeopleController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GetMapping()
    public String index() {
        return "people";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") People people) {
        return "new";
    }

    @PostMapping()
    public String addPerson(@ModelAttribute("person") People people) {
        peopleDAO.save(people);
        return "redirect:people";
    }
}