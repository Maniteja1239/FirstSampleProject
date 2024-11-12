package com.example.firstsample.representingInheritance.joinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_TAs")
public class TA extends User {
    private int numberOfSessions;
    private double avgRating;
}
