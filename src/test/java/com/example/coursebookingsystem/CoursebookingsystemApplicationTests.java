package com.example.coursebookingsystem;

import com.example.coursebookingsystem.models.Booking;
import com.example.coursebookingsystem.models.Course;
import com.example.coursebookingsystem.models.Customer;
import com.example.coursebookingsystem.repositories.BookingRepositories.BookingRepository;
import com.example.coursebookingsystem.repositories.CourseRepositories.CourseRepository;
import com.example.coursebookingsystem.repositories.CustomerRepositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursebookingsystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canMakeBookingsCustomersAndCourses(){
		Course course = new Course("Java", "Edinburgh", 5);
		courseRepository.save(course);
		Customer customer = new Customer("Nyalls", "Leeds", 22);
		customerRepository.save(customer);
		Booking booking = new Booking("12/03/2018", customer, course);
		bookingRepository.save(booking);
		}

	@Test
	public void canGetAllCustomersForCourse(){
		List<Customer> results = customerRepository.getAllCustomersForGivenCourse(1L);

	}

	@Test
	public void canGetAllCoursesForCustomer(){
		List<Course> results = courseRepository.getAllCoursesForGivenCustomer(1L);
	}

	@Test
	public void canGetAllCoursesWithGivenRating(){
		List<Course> results = courseRepository.getAllCoursesWithGivenRating(5);
	}

	@Test
	public void canGetAllBookingsWithDate(){
		List<Booking> results = bookingRepository.getBookingsForDate("23/05/2019");
	}

	@Test
	public void canGetCustomersForTownAndCourse(){
		List<Customer> results = customerRepository.getAllCustomersFromTownForCourse("Heaven", 2L);
	}

	@Test
	public void canGetCustomersOfAgeForTownAndCourse(){
		List<Customer> results = customerRepository.getCustomersOverAgeInTownForCourse(29, "Glasgow", 2L);
	}


}
