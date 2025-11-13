package org.example.customerservice.repository;

import org.example.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(path="customers")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
