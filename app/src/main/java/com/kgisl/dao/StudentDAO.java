package com.kgisl.dao;


import com.kgisl.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    void deleteById(Long id);
    void update(Student student);
}
