package com.example.coursebookingsystem.controllers;

import com.example.coursebookingsystem.models.Customer;
import com.example.coursebookingsystem.repositories.CustomerRepositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/course/{courseId}")
    public List<Customer> getAllCustomersForGivenCourse(@PathVariable Long courseId){
        return customerRepository.getAllCustomersForGivenCourse(courseId);
    }

    @GetMapping(value = "/town/{town}/course/{courseId}")
    public List<Customer> getAllCustomersFromTownForCourse(@PathVariable String town, @PathVariable Long courseId){
        return customerRepository.getAllCustomersFromTownForCourse(StringUtils.capitalize(town), courseId);
    }

    @GetMapping(value = "/over/{age}/town/{town}/course/{courseId}")
    public List<Customer> getCustomersOverAgeInTownForCourse(@PathVariable int age, @PathVariable String town, @PathVariable Long courseId){
        return customerRepository.getCustomersOverAgeInTownForCourse(age, StringUtils.capitalize(town), courseId);
    }

}
