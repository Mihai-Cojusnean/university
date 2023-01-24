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
@Table(name = "course", schema = "event_management")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name;
    int start_hour;
    int end_hour;
    String day;
    int school_year;

    @JoinColumn(name = "trainer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Trainer trainer;
}
