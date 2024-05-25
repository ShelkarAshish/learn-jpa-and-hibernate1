package com.in28minutes.springboot.course;

import com.in28minutes.springboot.course.jap.CourseJpaRepository;
import com.in28minutes.springboot.course.jdbc.CourseJDBCRepository;
import com.in28minutes.springboot.course.springDataJpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJDBCRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS", "in28minutes"));
        repository.save(new Course(2, "Learn AWS", "in28minutes"));
        repository.save(new Course(3, "Learn Ramdas Guru", "Jalva"));
        repository.save(new Course(4, "Learn AWS", "in28minutes"));

        repository.deleteById(2l);

        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());

        System.out.println(repository.findByAuthor("Jalva"));

    }
}
