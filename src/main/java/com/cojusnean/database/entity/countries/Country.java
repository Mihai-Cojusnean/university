package com.cojusnean.database.entity.countries;

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

    @OneToMany(targetEntity = City.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country", referencedColumnName = "name")
    List<City> cities;
}