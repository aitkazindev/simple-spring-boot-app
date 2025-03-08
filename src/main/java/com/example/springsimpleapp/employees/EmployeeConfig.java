package com.example.springsimpleapp.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return (args) -> {
            var studentList = List.of(
                    new Employee("name1", "email1", LocalDate.of(2000, 12, 12),  100000),
                    new Employee("name2", "email2", LocalDate.of(2000, 12, 12),  100000)
            );
            employeeRepository.saveAll(studentList);
        };
    }
}
