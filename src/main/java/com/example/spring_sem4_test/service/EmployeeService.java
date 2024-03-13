package com.example.spring_sem4_test.service;

import com.example.spring_sem4_test.entities.Employee;
import com.example.spring_sem4_test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee){
        return employeeRepository.findById(id)
                .map(e-> {
                    e.setName(employee.getName());
                    e.setAge(employee.getAge());
                    e.setSalary(employee.getSalary());
                    return employeeRepository.save(e);
                })
                .orElseGet(()->{
                    employee.setId(id);
                    return employeeRepository.save(employee);
                });
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public List<Employee> findEmployeesByName(String name) {
        return employeeRepository.findByNameContaining(name);
    }
}
