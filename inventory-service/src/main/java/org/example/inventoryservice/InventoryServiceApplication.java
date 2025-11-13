package org.example.inventoryservice;

import org.example.inventoryservice.entities.Product;
import org.example.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {

        return args -> {
            productRepository.save(Product.builder().name("laptop").price(4800).quantity(10).build());
            productRepository.save(Product.builder().name("iphone").price(8800).quantity(15).build());
            productRepository.save(Product.builder().name("readme").price(1200).quantity(50).build());
        };
    }

}
