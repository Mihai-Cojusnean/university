package com.cojusnean.controllers;

import com.cojusnean.database.entity.People;
import com.cojusnean.service.PeopleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("people")
public class PeopleController {

    private final PeopleDAO peopleDAO;

    @Autowired
    public PeopleController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GetMapping
    public List<People> getAll() {
        return peopleDAO.findAll();
    }

    @GetMapping("{id}")
    public People getOne(@PathVariable Long id) {
        return peopleDAO.get(id);
    }

    @PostMapping
    public People create(@RequestBody People person) {
        return peopleDAO.save(person);
    }

    @PutMapping("/{id}")
    public People update(@PathVariable("id") String peopleFromDb, @RequestBody People people) {
        return peopleDAO.update(peopleFromDb, people);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String person) {
        peopleDAO.delete(person);
    }
}