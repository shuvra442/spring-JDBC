package com.springJdbc.dao;

import com.springJdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student) {

        String query = "insert into springJdbc.student(id,name,address) values(?,?,?)";
        return this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getAddress());
    }

    @Override
    public int changeDetails(Student student) {

        String updateDetails= "update student set name=?, address=? where id=?"; ;
        return this.jdbcTemplate.update(updateDetails,student.getName(),student.getAddress(),student.getId());
    }

    @Override
    public int deleteDetails(int studentId) {
        String deleteDetailsQuery= "DELETE FROM student WHERE id=? ";
        return this.jdbcTemplate.update(deleteDetailsQuery, studentId);
    }

    @Override
    public Student getStudentData(int studentId) {
        String query="SELECT * FROM student WHERE id=?";
        RowMapper<Student> rowMapper =new RowMapperImpl();
        return this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
    }

    @Override
    public List<Student> getAllData() {
        String query="SELECT * FROM student";
        return this.jdbcTemplate.query(query, new RowMapperImpl());
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
