package com.cojusnean.database.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "enrollment", schema = "event_management")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String school_year;
    String cursus;
    short is_active;
    LocalDate created_at;
    String created_by;
    LocalDate updated_at;
    String updated_by;

    @JoinColumn(name = "student_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Student student;
}
