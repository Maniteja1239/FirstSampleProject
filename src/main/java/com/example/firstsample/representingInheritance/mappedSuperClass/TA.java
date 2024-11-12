package com.example.firstsample.representingInheritance.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_TAs")
public class TA extends User{
    private int numberOfSessions;
    private double avgRating;
}
