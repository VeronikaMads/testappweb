package com.example.testapp.api;

import com.example.testapp.dao.service.EmployeeService;
import com.example.testapp.entity.Employee;
import com.example.testapp.entity.dto.EmployeeDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@ComponentScan({"com.example.testapp.service"})
@RequestMapping("/employee")
@RequiredArgsConstructor
@RestController
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @ApiOperation(value = "Find employees", response = Employee.class, responseContainer = "List")
    @PutMapping("/find")
    public List<EmployeeDto> findEmployees(@ApiParam(value = "Search example") @RequestBody EmployeeDto employeeDto) {
        return employeeService.findEmployee(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
    }

    @PostMapping()
    public void createEmployee(@Valid @RequestBody EmployeeDto dto) {
        employeeService.save(dto);
    }

    @ApiOperation(value = "Find employee by ID", response = Employee.class, responseContainer = "Object")
    @GetMapping("/{id}")
    public EmployeeDto findById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody EmployeeDto dto) {
        employeeService.save(id, dto);
    }
}
