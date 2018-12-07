package com.example.coursebookingsystem.projections;

import com.example.coursebookingsystem.models.Booking;
import com.example.coursebookingsystem.models.Course;
import com.example.coursebookingsystem.models.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedCustomerAndCourse", types = Booking.class)
public interface EmbedCustomerAndCourse {
    String getDate();
    Customer getCustomer();
    Course getCourse();
}
