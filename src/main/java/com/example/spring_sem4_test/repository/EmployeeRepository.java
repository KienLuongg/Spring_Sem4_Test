package com.example.spring_sem4_test.repository;

import com.example.spring_sem4_test.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByNameContaining(String name);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> findByName(@Param("name") String name);
}
