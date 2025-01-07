package org.example.spring_test.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class EmployeeResDTO {
    private Long id;
    private String name;
    private String age;
    private double salary;

    public EmployeeResDTO(Long id, String name, String age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
