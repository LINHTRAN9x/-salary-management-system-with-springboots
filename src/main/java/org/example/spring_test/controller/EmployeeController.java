package org.example.spring_test.controller;

import org.example.spring_test.dto.req.EmployeeReqDTO;
import org.example.spring_test.dto.res.EmployeeResDTO;
import org.example.spring_test.entity.Employee;
import org.example.spring_test.mapper.EmployeeMapper;
import org.example.spring_test.repository.EmployeeRepository;
import org.example.spring_test.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResDTO>> getAllEmployees() {
        List<EmployeeResDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Tạo nhân viên mới
    @PostMapping
    public ResponseEntity<EmployeeResDTO> createEmployee(@RequestBody EmployeeReqDTO employeeReqDTO) {
        EmployeeResDTO createdEmployee = employeeService.saveEmployee(employeeReqDTO);
        return ResponseEntity.ok(createdEmployee);
    }

    // Lấy thông tin chi tiết của một nhân viên theo ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResDTO> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Cập nhật thông tin nhân viên
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeReqDTO employeeReqDTO) {
        EmployeeResDTO updatedEmployee = employeeService.updateEmployee(id, employeeReqDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Xóa nhân viên theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Tìm kiếm nhân viên theo tên
    @GetMapping("/search")
    public ResponseEntity<List<EmployeeResDTO>> searchEmployees(@RequestParam String name) {
        List<EmployeeResDTO> employees = employeeService.searchEmployees(name);
        return ResponseEntity.ok(employees);
    }
}
