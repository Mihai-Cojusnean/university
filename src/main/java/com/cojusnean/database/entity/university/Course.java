package com.cojusnean.database.entity.university;

import com.cojusnean.database.entity.people.Trainer;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;
    int startHour;
    int endHour;
    String day;
    int schoolYear;

    @JoinColumn(name = "trainerId")
    @ManyToOne(fetch = FetchType.LAZY)
    Trainer trainer;
}