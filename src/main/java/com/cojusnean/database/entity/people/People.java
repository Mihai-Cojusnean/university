package com.cojusnean.database.entity.people;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "people", schema = "event_management")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String lastName;
    String firstName;
    String gender;
    String dateOfBirth;
    String phone;
    String email;
    String address;
    String city;
    String country;
    String addedBy;
    String updatedBy;
    String addedAt;
    String updatedAt;
}