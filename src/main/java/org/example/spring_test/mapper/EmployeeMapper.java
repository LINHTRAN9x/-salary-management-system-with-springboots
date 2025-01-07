package org.example.spring_test.mapper;

import org.example.spring_test.dto.req.EmployeeReqDTO;
import org.example.spring_test.dto.res.EmployeeResDTO;
import org.example.spring_test.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeReqDTO employeeReqDTO);
    EmployeeResDTO toDTO(Employee employee);
}
