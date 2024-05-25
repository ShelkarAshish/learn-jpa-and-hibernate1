package com.in28minutes.springboot.course.jdbc;

import com.in28minutes.springboot.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {

    @Autowired
    private JdbcTemplate springJDBCTemplete;

    private static String INSERT_QUERY =
            """
                insert into course (id, name, author)
                values(?, ?, ?);    
            """;

    private static String DELETE_QUERY =
            """
                delete from course
                where id=?    
            """;

    private static String SELECT_QUERY =
            """
                select * from course
                where id=?    
            """;

    public void insert(Course course){
        springJDBCTemplete.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void setDeleteQuery(long id){
        springJDBCTemplete.update(DELETE_QUERY, id);
    }

    public Course findById(long id){
        return springJDBCTemplete.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class), id);
    }

}
