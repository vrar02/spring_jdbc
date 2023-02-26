package com.vivek.springjdbc.dao;

import com.vivek.springjdbc.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class RowMapperStudentImpl implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student=new Student();
        student.setId(resultSet.getInt(1));
        student.setCity(resultSet.getString(2));
        student.setName(resultSet.getString(3));
        return student;
    }
}
