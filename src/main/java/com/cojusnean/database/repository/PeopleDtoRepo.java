package com.cojusnean.database.repository;

import com.cojusnean.database.entity.people.PeopleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleDtoRepo extends JpaRepository<PeopleDTO, Long> {
}
