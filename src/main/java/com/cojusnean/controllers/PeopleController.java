package com.cojusnean.controllers;

import com.cojusnean.database.entity.people.People;
import com.cojusnean.database.repository.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping("/people")
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

    @GetMapping("/{id}")
    public People getOne(@PathVariable Long id) {
        return peopleRepo.getReferenceById(id);
    }

    @PostMapping("/")
    public People create(@RequestBody People person) {
        person.setAddedAt(getNowTime());
        return peopleRepo.save(person);
    }

    @PutMapping("/{id}")
    public People update(@RequestBody People person) {
        person.setUpdatedAt(getNowTime());
        return peopleRepo.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        peopleRepo.deleteById(id);
    }

    protected String getNowTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(formatter);
    }
}