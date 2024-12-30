package com.elmarrakchy.customerservice;

import com.elmarrakchy.customerservice.entities.Customer;
import com.elmarrakchy.customerservice.repositories.CustomerRepository;
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
            for (int i = 0; i < 10; i++) {
                Customer customer = Customer.builder()
                        .name("Customer" + i)
                        .email("customer" + i + "@gmail.com")
                        .build();
                customerRepository.save(customer);
            }
            customerRepository.findAll().forEach(customer -> {
                System.out.println(customer.toString());
            });
        };
    }
}
