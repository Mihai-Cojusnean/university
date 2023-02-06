package com.cojusnean.service;

import com.cojusnean.database.entity.People;
import com.cojusnean.database.repository.PeopleRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleDAO {

    private final PeopleRepo peopleRepo;

    public PeopleDAO(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    public People get(Long id) {
        return peopleRepo.findById(id);
    }

    public People save(People person) {
        return peopleRepo.save(person);
    }

    public List<People> findAll() {
        return peopleRepo.findAll();
    }

    public void delete(String id) {
        peopleRepo.deleteById(Long.parseLong(id));
    }

    public People update(String id, People person) {
        People personFromDb = peopleRepo.findById(Long.parseLong(id));
        BeanUtils.copyProperties(person, personFromDb, "id");
        return peopleRepo.save(person);
    }
}
