package com.example.spring_sem4_test.controllers;

import com.example.spring_sem4_test.entities.Employee;
import com.example.spring_sem4_test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping()
    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }

    @PostMapping()
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployeesByName(@RequestParam("name") String name) {
        List<Employee> employees = employeeService.findEmployeesByName(name);
        return ResponseEntity.ok(employees);
    }

}
