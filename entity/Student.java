package com.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String course;
    private double fee;

    public Student() {}

    public Student(String name, String course, double fee) {
        this.name = name;
        this.course = course;
        this.fee = fee;
    }

    // Getters and Setters
}
