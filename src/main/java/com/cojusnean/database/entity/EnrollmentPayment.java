package com.cojusnean.database.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "enrollment_payment", schema = "event_management")
public class EnrollmentPayment {

    String type;
    float amount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "EnrollmentPayment")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Funding> funding_id;

    @JoinColumn(name = "enrollment_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Enrollment enrollment_id;
}
