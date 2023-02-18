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
@Table(name = "funding", schema = "event_management")
public class Funding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    float totalAmount;
    String status;
}
