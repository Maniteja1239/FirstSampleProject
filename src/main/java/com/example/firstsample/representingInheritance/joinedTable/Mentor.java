package com.example.firstsample.representingInheritance.joinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentors")
public class Mentor extends User {
    private double avgMentorRating;
}
