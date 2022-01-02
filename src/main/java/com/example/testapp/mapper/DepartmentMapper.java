package com.example.testapp.mapper;

import com.example.testapp.entity.Department;
import com.example.testapp.entity.dto.DepartmentDto;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {
    Department map(DepartmentDto dto);

    DepartmentDto mapToDto(Department entity);

}
