package com.example.testapp.dao.service.jpa;

import com.example.testapp.dao.service.EmployeeService;
import com.example.testapp.dao.service.config.JpaImplementation;
import com.example.testapp.entity.Employee;
import com.example.testapp.entity.dto.EmployeeDto;
import com.example.testapp.mapper.EmployeeMapper;
import com.example.testapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@JpaImplementation
public class EmployeeJpaServiceImpl extends AbstractJpaService<EmployeeDto, Employee,Long> implements EmployeeService {
    private final EmployeeMapper mapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public JpaRepository<Employee, Long> getRepository() {
        return employeeRepository;
    }

    @Override
    public void save(EmployeeDto entity) {
        super.save(entity);
    }

    @Override
    public void delete(Long aLong) {
        super.delete(aLong);
    }

    @Override
    public EmployeeDto update(Long aLong, EmployeeDto entity) {
        return super.update(aLong, entity);
    }

    @Override
    public Collection<EmployeeDto> findAll() {
        return super.findAll();
    }

    @Override
    public EmployeeDto findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public EmployeeDto mapToDto(Employee entity) {
        return mapper.mapToDto(entity);
    }

    @Override
    public Employee mapToEntity(EmployeeDto dto) {
        return mapper.map(dto);
    }

    @Override
    public Collection<EmployeeDto> findByName(String name) {
        return employeeRepository.findByLastNameLike(name).stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void save(Long id, EmployeeDto employeeDto) {
        employeeRepository.save(mapToEntity(employeeDto));
    }

}
