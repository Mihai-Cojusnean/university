package com.cojusnean.database.repository;

import com.cojusnean.database.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, String> {

    People findById(long id);

}
