package com.wct.mybatis.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private int studId;
    private String name;
    private String email;
    private Date dob;

    public Student(String name, String email, Date dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student() {
    }
}
