package com.wct.mybatis.mappers;

import com.wct.mybatis.entity.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> findAllStudents();
    Student findStudentById(Integer id);
    void insertStudent(Student student);
    void update(Student student);
}
