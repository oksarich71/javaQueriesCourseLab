package com.example.coursebookingsystem.repositories.CustomerRepositories;

import com.example.coursebookingsystem.models.Course;
import com.example.coursebookingsystem.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> getAllCustomersForGivenCourse(Long courseId);

    List<Customer> getAllCustomersFromTownForCourse(String town, Long courseId);

    List<Customer> getCustomersOverAgeInTownForCourse(int age, String town, Long courseId);
}
