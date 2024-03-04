package com.springJdbc.config;

import com.springJdbc.dao.StudentDao;
import com.springJdbc.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.springJdbc.dao"})
public class JdbcConfig {

    @Bean(name= {"ds"})
    public DataSource getDataSource(){
        DriverManagerDataSource managerDataSource= new DriverManagerDataSource();
        managerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        managerDataSource.setUrl("jdbc:mysql://localhost:3306/springJdbc");
        managerDataSource.setUsername("root");
        managerDataSource.setPassword("rootroot");
        return managerDataSource;
    }

    @Bean(name={"jdbcTemplate"})
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
/**
 * if cant define @Bean of StudentDao the then configure it @Component --> StudentDao annotation
 */
//    @Bean(name = {"studentDao"})
//    public StudentDao getStudent(){
//        StudentDaoImpl studentDao= new StudentDaoImpl();
//        studentDao.setJdbcTemplate(getTemplate());
//        return studentDao;
//    }

}
