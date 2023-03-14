package com.cojusnean.database.entity.countries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "country", schema = "data")
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @JsonIgnore
    @OneToMany(targetEntity = City.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    List<City> cities;
}