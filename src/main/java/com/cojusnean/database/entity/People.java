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

    public People(String last_name, String first_name, String form, short gender, String date_of_birth, String phone, String email, String address, String city, String country) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.form = form;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
    }
}
