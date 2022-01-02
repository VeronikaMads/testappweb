package com.example.testapp.repository;

import com.example.testapp.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void test1_save() {
        //given
        Employee employee = Employee.builder()
                .firstName("fn")
                .lastName("ln")
                .jobTitle("ec")
                .build();

        //when
        Employee result = employeeRepository.save(employee);

        //then
        assertNotNull(result);
        assertEquals("fn", result.getFirstName());
        assertEquals("ln", result.getLastName());
        assertEquals("ec", result.getJobTitle());
    }

}
