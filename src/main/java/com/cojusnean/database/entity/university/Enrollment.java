package com.cojusnean.database.entity.university;

import com.cojusnean.database.entity.people.Student;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String schoolYear;
    String curs;
    short isActive;
    LocalDate createdAt;
    String createdBy;
    LocalDate updatedAt;
    String updatedBy;

    @JoinColumn(name = "studentId")
    @ManyToOne(fetch = FetchType.LAZY)
    Student student;
}