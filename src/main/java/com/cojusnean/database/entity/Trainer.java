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
@Table(name = "trainer", schema = "event_management")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String type;
    short isActive;

    @JoinColumn(name = "peopleId")
    @ManyToOne(fetch = FetchType.LAZY)
    People people;
}
