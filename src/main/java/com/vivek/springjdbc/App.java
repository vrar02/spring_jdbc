package com.vivek.springjdbc;


import com.vivek.springjdbc.dao.StudentDao;
import com.vivek.springjdbc.dao.StudentDaoImpl;
import com.vivek.springjdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan(basePackages = {"com.vivek.springjdbc"})
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(App.class);
//        JdbcTemplate jdbcTemplate = context.getBean("getJdbcTemplate", JdbcTemplate.class);
        Student student=new Student(116,"banglore","reddy");

//        String query="insert into student_info(id,city,name) values(?,?,?)";
//        int r = jdbcTemplate.update(query, student.getId(), student.getCity(), student.getName());
//        System.out.println(" Row inserted "+r);

        StudentDao studentDao=context.getBean("studentDaoImpl",StudentDaoImpl.class);

        studentDao.insert(student);

        studentDao.update(student);

        studentDao.delete(116);

        studentDao.get(113);

        studentDao.getAll();

    }
}
