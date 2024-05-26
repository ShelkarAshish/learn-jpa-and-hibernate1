package com.in28minutes.springboot.course.controller;

import com.in28minutes.springboot.course.Course;
import com.in28minutes.springboot.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
//        return Arrays.asList(new Course(1, "Learn MicroServices", "in28minutes"), new Course(2, "Learn Full Stack with Angular and React", "in28minutes"));
    }

    @GetMapping("/courses/{id}")
    public Optional<Course> getCourseDetails(@PathVariable long id){
        return courseRepository.findById(id);
//        return new Course(1, "Learn MicroServices", "in28minutes");
    }

    @PostMapping("/courses")
    public void createCourse(@RequestBody Course course){
        courseRepository.save(course);
    }

    @PutMapping("/courses/{id}")
    public void createCourse(@PathVariable long id,@RequestBody Course course){
        courseRepository.save(course);
    }

    @DeleteMapping("/courses/{id}")
    public void createCourse(@PathVariable long id){
        courseRepository.deleteById(id);
    }

}
