package org.example.spring_test.service;

import org.example.spring_test.dto.req.EmployeeReqDTO;
import org.example.spring_test.dto.res.EmployeeResDTO;
import org.example.spring_test.entity.Employee;
import org.example.spring_test.mapper.EmployeeMapper;
import org.example.spring_test.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    public List<EmployeeResDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }


    public Optional<EmployeeResDTO> getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toDTO);
    }


    public EmployeeResDTO saveEmployee(EmployeeReqDTO employeeReqDTO) {
        Employee employee = employeeMapper.toEntity(employeeReqDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);
    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


    public List<EmployeeResDTO> searchEmployees(String name) {
        return employeeRepository.findByNameContaining(name)
                .stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }


    public EmployeeResDTO updateEmployee(Long id, EmployeeReqDTO employeeReqDTO) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();


            existingEmployee.setName(employeeReqDTO.getName());
            existingEmployee.setAge(employeeReqDTO.getAge());
            existingEmployee.setSalary(employeeReqDTO.getSalary());


            Employee updatedEmployee = employeeRepository.save(existingEmployee);
            return employeeMapper.toDTO(updatedEmployee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }
}
