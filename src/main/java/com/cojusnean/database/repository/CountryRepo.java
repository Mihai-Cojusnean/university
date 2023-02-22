package com.cojusnean.database.repository;

import com.cojusnean.database.entity.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
    Country findByName(String name);
}
