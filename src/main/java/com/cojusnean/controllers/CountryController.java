package com.cojusnean.controllers;

import com.cojusnean.database.entity.countries.City;
import com.cojusnean.database.entity.countries.Country;
import com.cojusnean.database.repository.CountryRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryRepo countryRepo;

    public CountryController(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @GetMapping()
    public List<Country> getAll() {
        return countryRepo.findAll();
    }

    @GetMapping("/{country}")
    public List<City> getCities(@PathVariable String country) {
        return countryRepo.findByName(country).getCities();
    }
}
