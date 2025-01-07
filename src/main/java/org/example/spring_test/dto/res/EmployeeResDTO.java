package org.example.spring_test.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeResDTO {
    private Long id;
    private String name;
    private String age;
    private double salary;
}
