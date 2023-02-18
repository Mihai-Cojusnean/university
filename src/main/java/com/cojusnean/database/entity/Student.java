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
@Table(name = "student", schema = "event_management")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    short isActive;

    @JoinColumn(name = "people_id")
    @ManyToOne(fetch = FetchType.LAZY)
    People people;
}
