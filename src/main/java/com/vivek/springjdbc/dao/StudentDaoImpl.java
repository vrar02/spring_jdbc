package com.vivek.springjdbc.dao;

import com.vivek.springjdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Student student) {
        //Here we dont need to handle the checked exceptions...all are runtime exceptions...
        String query="insert into student_info(id,city,name) values(?,?,?)";
        int update = this.jdbcTemplate.update(query, student.getId(), student.getCity(), student.getName());
        System.out.println(update+ " row inserted");
    }

    @Override
    public Student get(int id) {

        String query="select * from student_info where id=?";

        return null;
    }

    @Override
    public void getAll() {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Student student) {

    }
}
