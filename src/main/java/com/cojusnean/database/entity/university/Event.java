package com.cojusnean.database.entity.university;

import com.cojusnean.database.entity.people.Speaker;
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
@Table(name = "event", schema = "event_management")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;
    LocalDate startDate;
    LocalDate endDate;
    String type;
    short isActive;
    LocalDate createdAt;
    String createdBy;
    LocalDate updatedAt;
    String updatedBy;

    @JoinColumn(name = "speakerId")
    @ManyToOne(fetch = FetchType.LAZY)
    Speaker speaker;
}