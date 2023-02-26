package com.vivek.springjdbc.dao;

import com.vivek.springjdbc.entities.Student;

public interface StudentDao {

    void insert(Student student);
    Student get(int id);
    void getAll();
    void delete(int id);
    void update(Student student);

}
