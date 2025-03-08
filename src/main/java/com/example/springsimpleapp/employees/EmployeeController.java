package com.example.springsimpleapp.employees;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getStrings() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeService.createEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        this.employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/{employeeId}")
    public void updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "salary", required = false) Integer salary
    ) {
        this.employeeService.updateEmployee(employeeId, email, salary);
    }

}
