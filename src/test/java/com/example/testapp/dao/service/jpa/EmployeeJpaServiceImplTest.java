package com.example.testapp.dao.service.jpa;

import com.example.testapp.entity.Employee;
import com.example.testapp.entity.dto.EmployeeDto;
import com.example.testapp.mapper.EmployeeMapper;
import com.example.testapp.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeJpaServiceImplTest {
    EmployeeJpaServiceImpl employeeJpaService;
    @Mock
    private EmployeeMapper mapper;
    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        employeeJpaService = new EmployeeJpaServiceImpl(mapper,employeeRepository);
    }

    @Test
    public void findByName() {
        //given
        String name = "test_name";
        Employee employee = Employee.builder().lastName(name).build();
        List<Employee> employeeList = List.of(employee);
        when(employeeRepository.findByLastNameLike(name)).thenReturn(employeeList);
        EmployeeDto employeeDto = EmployeeDto.builder().lastName(name).build();
        when(mapper.mapToDto(employee)).thenReturn(employeeDto);
        //when
        Collection<EmployeeDto> result = employeeJpaService.findByName(name);
        //then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(employeeDto,result.stream().findFirst().get());
    }
}
