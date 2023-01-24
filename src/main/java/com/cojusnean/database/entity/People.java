package com.cojusnean.database.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "people", schema = "event_management")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String last_name;
    String first_name;
    String form;
    short gender;
    String date_of_birth;
    String phone;
    String email;
    String address;
    String city;
    String country;
}
