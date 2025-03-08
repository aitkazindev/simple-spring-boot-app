package com.example.springsimpleapp;

import com.example.springsimpleapp.employees.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@SpringBootApplication
public class SpringSimpleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSimpleAppApplication.class, args);
    }



}
