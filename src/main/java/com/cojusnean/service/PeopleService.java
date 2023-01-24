package com.cojusnean.service;

import com.cojusnean.database.entity.People;
import com.cojusnean.database.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People getUser(long chatId) {
        People people = peopleRepository.findById(chatId);

        if (isNull(people)) people = saveUser(chatId);
        return people;
    }

    public People saveUser(long update) {
        return peopleRepository.save(new People());
    }
}
