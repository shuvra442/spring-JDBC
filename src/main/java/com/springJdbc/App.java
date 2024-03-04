package com.springJdbc;

import com.springJdbc.config.JdbcConfig;
import com.springJdbc.dao.StudentDao;
import com.springJdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("hi im here");
        ApplicationContext context= new AnnotationConfigApplicationContext(JdbcConfig.class);

//        1. approch
//        JdbcTemplate template= context.getBean("jdbcTemplate", JdbcTemplate.class);

//        //  this query help to insert data into database
//        String query="insert into springJdbc.student(id,name,address) values(?,?,?)";
//
////        fire query
//        int result = template.update(query,2,"shuvankar","nachipur");
//        System.out.println(result);

//        2nd approach
       StudentDao studentDao= context.getBean("studentDao", StudentDao.class);

//          insert method
//        Student student=new Student();
//        student.setId(4);
//        student.setName("soumik");
//        student.setAddress("keshapat");
//       int result= studentDao.insert(student);
//       System.out.println(result);

//        update method
//        Student student = new Student();
//        student.setId(4);
//        student.setName("sombhu");
//        student.setAddress("sabang");
//
//        int result = studentDao.changeDetails(student);
//        System.out.println(result);

//        delete method
//        int deletedData = studentDao.deleteDetails(4);
//        System.out.println(deletedData);

//        select data from database
//        Student student=studentDao.getStudentData(1);
//        System.out.println(student);

//        get all data from database
        List<Student> students=studentDao.getAllData();
        for (Student s: students){
            System.out.println(s);
        }
    }
}
