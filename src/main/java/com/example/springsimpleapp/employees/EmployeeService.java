package com.example.springsimpleapp.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {

        if (employee.getId() != null){
            throw new IllegalArgumentException("Employee id must be null");
        }

        // check for email uniqueness
        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        if (employee.getSalary() < 5000){
            throw new IllegalArgumentException("Salary must be greater than 5000");
        }
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        if (employeeRepository.existsById(employeeId)){
            employeeRepository.deleteById(employeeId);
        } else {
            throw new IllegalArgumentException("Employee with id " + employeeId + " does not exist");
        }
    }

    @Transactional
    public void updateEmployee(
            Long id,
            String email,
            Integer salary
    ){
        System.out.println(id);
        System.out.println(email);
        System.out.println(salary);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id " + id + " does not exist"));

        if (email != null && !email.isBlank() && !email.equals(employee.getEmail())){
            if (employeeRepository.findByEmail(email).isPresent()){
                throw new IllegalArgumentException("Email already exists");
            }
            employee.setEmail(email);
        }

        if (salary != null && salary > 5000){
            employee.setSalary(salary);
        }
    }
}