package com.example.coursebookingsystem.repositories.CustomerRepositories;

import com.example.coursebookingsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
}
