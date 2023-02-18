package com.cojusnean.database.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "people", schema = "event_management")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String lastName;
    String firstName;
    String form;
    String gender;
    String dateOfBirth;
    String phone;
    String email;
    String address;
    String city;
    String country;
}