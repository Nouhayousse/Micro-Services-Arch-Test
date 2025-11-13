package org.example.customerservice;

import org.example.customerservice.entities.Customer;
import org.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {

            customerRepository.save(new Customer("Youssefi","youssefi@gmail.com", "0667578409"));

        };
    }

}
