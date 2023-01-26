package com.cojusnean.service;

import com.cojusnean.database.entity.People;
import com.cojusnean.database.repository.PeopleRepository;
import org.springframework.stereotype.Service;

@Service
public class PeopleDAO {

    private final PeopleRepository peopleRepository;

    public PeopleDAO(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

//    public People getUser(People people) {
////        People people = peopleRepository.findById(chatId);
////
////        if (isNull(people)) people = save(chatId);
////        return people;
//    }

    public void save(People people) {
        peopleRepository.save(people);
    }
}
