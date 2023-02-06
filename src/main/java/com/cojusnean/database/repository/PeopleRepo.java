package com.cojusnean.database.repository;

import com.cojusnean.database.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PeopleRepo extends JpaRepository<People, String> {

    People findById(long id);
    @Transactional
    void deleteById(Long id);
}
