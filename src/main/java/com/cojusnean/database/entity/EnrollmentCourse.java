package com.cojusnean.database.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "enrollment_course", schema = "event_management")
public class EnrollmentCourse {

    @JoinColumn(name = "course_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Course course;

    @JoinColumn(name = "enrollment_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Enrollment enrollment;
}
