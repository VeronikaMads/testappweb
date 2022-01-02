package com.example.testapp.mapper;

import com.example.testapp.entity.Employee;
import com.example.testapp.entity.dto.EmployeeDto;
import org.mapstruct.Mapper;

@Mapper(uses = DepartmentMapper.class)
public interface EmployeeMapper {
    Employee map(EmployeeDto dto);

    EmployeeDto mapToDto(Employee entity);
}
