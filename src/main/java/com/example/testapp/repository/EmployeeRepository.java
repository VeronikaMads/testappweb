package com.example.testapp.repository;

import com.example.testapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByLastNameLike(String name);

    List<Employee> findByLastNameIgnoreCase(String lastName);
}
