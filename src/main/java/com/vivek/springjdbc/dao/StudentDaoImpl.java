package com.vivek.springjdbc.dao;

import com.vivek.springjdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public void update(Student student) {

        String query="update student_info set city='bengaluru' where city='banglore' and id=?";
        int update=this.jdbcTemplate.update(query,student.getId());
        System.out.println(update+ " row updated");

    }

    @Override
    public void delete(int id) {
        String query="delete from student_info where id=?";
        int update = this.jdbcTemplate.update(query, id);
        System.out.println(update+" row deleted");
    }

    @Override
    public Student get(int id) {
        String query="select * from student_info where id=?";
        RowMapper<Student> rowMapper=new RowMapperStudentImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper,id);
        System.out.println(student);
        return student;
    }

    @Override
    public void getAll() {

        String query="select * from student_info";
        List<Student> studentList = this.jdbcTemplate.query(query, new RowMapperStudentImpl());
        for (Student student : studentList) {
            System.out.println(student);
        }

    }

}
