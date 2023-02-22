package com.cojusnean.controllers;

import com.cojusnean.database.entity.people.People;
import com.cojusnean.database.entity.people.PeopleDTO;
import com.cojusnean.database.repository.PeopleDtoRepo;
import com.cojusnean.database.repository.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cojusnean.util.DataUtil.getNowTime;


@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleRepo peopleRepo;
    private final PeopleDtoRepo peopleDtoRepo;

    @Autowired
    public PeopleController(PeopleRepo peopleRepo, PeopleDtoRepo peopleDtoRepo) {
        this.peopleRepo = peopleRepo;
        this.peopleDtoRepo = peopleDtoRepo;
    }

    @GetMapping("/peoples")
    public List<PeopleDTO> getAll() {
        return peopleDtoRepo.findAll();
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
}