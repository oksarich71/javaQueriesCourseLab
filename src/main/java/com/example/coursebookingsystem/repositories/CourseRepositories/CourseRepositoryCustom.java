package com.example.coursebookingsystem.repositories.CourseRepositories;

import com.example.coursebookingsystem.models.Course;
import com.example.coursebookingsystem.models.Customer;

import java.util.List;

public interface CourseRepositoryCustom {
    List<Course> getAllCoursesWithGivenRating(int rating);

    List<Course> getAllCoursesForGivenCustomer(Long customerId);
}
