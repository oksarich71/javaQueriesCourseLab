package com.example.coursebookingsystem.components;


import com.example.coursebookingsystem.models.Booking;
import com.example.coursebookingsystem.models.Course;
import com.example.coursebookingsystem.models.Customer;
import com.example.coursebookingsystem.repositories.BookingRepositories.BookingRepository;
import com.example.coursebookingsystem.repositories.CourseRepositories.CourseRepository;
import com.example.coursebookingsystem.repositories.CustomerRepositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {
        Course course1 = new Course("Java", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Ruby", "Glasgow", 4);
        courseRepository.save(course2);

        Customer customer1 = new Customer("Katie", "Hell", 46);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Oksana", "Heaven", 28);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("23-05-2019", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("23-05-2019", customer2, course2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("22-12-2025", customer1, course2);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("25-12-2030", customer2, course1);
        bookingRepository.save(booking4);
    }
}
