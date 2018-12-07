package com.example.coursebookingsystem.controllers;

import com.example.coursebookingsystem.models.Course;
import com.example.coursebookingsystem.repositories.CourseRepositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/rating/{rating}")

    public List<Course> getAllCoursesWithGivenRating(@PathVariable int rating) {
        return courseRepository.getAllCoursesWithGivenRating(rating);
    }

    @GetMapping(value = "/customer/{customerId}")
    public List<Course> getAllCoursesForGivenCustomer(@PathVariable Long customerId) {
        return courseRepository.getAllCoursesForGivenCustomer(customerId);
    }
}
