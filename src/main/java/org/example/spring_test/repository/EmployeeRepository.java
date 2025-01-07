package org.example.spring_test.repository;

import org.example.spring_test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String name);
}
