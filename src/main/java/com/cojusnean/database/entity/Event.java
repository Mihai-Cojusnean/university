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
@Table(name = "event", schema = "event_management")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name;
    LocalDate start_date;
    LocalDate end_date;
    String type;
    short is_active;
    LocalDate created_at;
    String created_by;
    LocalDate updated_at;
    String updated_by;

    @JoinColumn(name = "speaker_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Speaker speaker;
}
