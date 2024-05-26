package com.in28minutes.springboot.course.repository;

import com.in28minutes.springboot.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
