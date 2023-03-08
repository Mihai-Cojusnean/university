package com.cojusnean.service;

import com.cojusnean.database.entity.people.People;
import com.cojusnean.database.repository.PeopleRepo;
import com.cojusnean.util.DataUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    private final PeopleRepo peopleRepo;

    public PeopleService(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    public List<People> findAll() {
        return peopleRepo.findAll();
    }

    public People get(Long id) {
        return peopleRepo.getById(id);
    }

    public People save(People person) {
        person.setAddedAt(DataUtil.getNowTime());
        return peopleRepo.save(person);
    }

    public void delete(Long id) {
        peopleRepo.deleteById(id);
    }

    public People update(People person) {
        People personFromDb = peopleRepo.getReferenceById(person.getId());
        if (person.getFirstName() != null) personFromDb.setFirstName(person.getFirstName());
        if (person.getLastName() != null) personFromDb.setLastName(person.getLastName());
        if (person.getDateOfBirth() != null) personFromDb.setDateOfBirth(person.getDateOfBirth());
        if (person.getGender() != null) personFromDb.setGender(person.getGender());
        if (person.getAddress() != null) personFromDb.setAddress(person.getAddress());
        if (person.getCountry() != null) personFromDb.setCountry(person.getCountry());
        if (person.getCity() != null) personFromDb.setCity(person.getCity());
        if (person.getPhone() != null) personFromDb.setPhone(person.getPhone());
        personFromDb.setUpdatedAt(DataUtil.getNowTime());
        personFromDb.setUpdatedBy(person.getUpdatedBy());
        return peopleRepo.save(personFromDb);
    }
}
