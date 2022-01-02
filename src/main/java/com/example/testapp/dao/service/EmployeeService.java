package com.example.testapp.dao.service;

import com.example.testapp.entity.dto.EmployeeDto;

import java.util.Collection;
import java.util.List;

public interface EmployeeService extends CrudService<EmployeeDto, Long> {
    default EmployeeDto getEmployeeDetails(Long id) {
        throw new UnsupportedOperationException();
    }

    default List<EmployeeDto> findEmployee(EmployeeDto employeeDto) {
        throw new UnsupportedOperationException();
    }

    default Collection<EmployeeDto> findByName(String name) {
        throw new UnsupportedOperationException();
    }

    void save(Long id, EmployeeDto dto);

}
