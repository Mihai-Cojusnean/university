package com.cojusnean.database.entity.countries;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "city", schema = "data")
public class City {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
}