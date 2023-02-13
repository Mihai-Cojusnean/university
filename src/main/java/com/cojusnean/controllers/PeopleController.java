package com.cojusnean.controllers;

import com.cojusnean.database.entity.People;
import com.cojusnean.database.repository.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("people")
@CrossOrigin("http://localhost:5173/")
public class PeopleController {

    private final PeopleRepo peopleRepo;

    @Autowired
    public PeopleController(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    @GetMapping
    public List<People> getAll() {
        return peopleRepo.findAll();
    }

    @GetMapping("{id}")
    public People getOne(@PathVariable Long id) {
        return peopleRepo.getReferenceById(id);
    }

    @PostMapping
    public People create(@RequestBody People person) {
        return peopleRepo.save(person);
    }

    @PutMapping("{id}")
    public People update(@RequestBody People people) {
        return peopleRepo.save(people);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        peopleRepo.deleteById(id);
    }
}