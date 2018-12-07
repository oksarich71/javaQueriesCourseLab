package com.example.coursebookingsystem.repositories.BookingRepositories;

import com.example.coursebookingsystem.models.Booking;

import java.util.List;

public interface BookingRepositoryCustom {
    List<Booking> getBookingsForDate(String date);
}
