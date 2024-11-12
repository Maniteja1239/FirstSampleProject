package com.example.firstsample.representingInheritance.tablePerClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instructor extends User {
    private String specialization;
}
