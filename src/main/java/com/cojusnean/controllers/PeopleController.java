package com.cojusnean.controllers;

import com.cojusnean.database.entity.people.People;
import com.cojusnean.service.PeopleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<People> getAll() {
        return peopleService.findAll();
    }

    @GetMapping("/{id}")
    public People getOne(@PathVariable Long id) {
        return peopleService.get(id);
    }

    @PostMapping
    public People create(@RequestBody People person) {
        return peopleService.save(person);
    }

    @PutMapping("/{id}")
    public People update(@RequestBody People person) {
        return peopleService.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        peopleService.delete(id);
    }
}