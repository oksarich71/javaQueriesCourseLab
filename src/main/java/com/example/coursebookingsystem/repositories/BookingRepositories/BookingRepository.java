package com.example.coursebookingsystem.repositories.BookingRepositories;

import com.example.coursebookingsystem.models.Booking;
import com.example.coursebookingsystem.projections.EmbedCustomerAndCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(excerptProjection = EmbedCustomerAndCourse.class)
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {
}
