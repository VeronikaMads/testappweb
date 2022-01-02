package com.example.testapp.entity.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeDtoTest {
    EmployeeDto employeeDto;

    @Before
    public void setUp() throws Exception {
        employeeDto= new EmployeeDto();
    }

    @Test
    public void getEmployeeId() {
        //given
        Long id = 123L;
        //when
        employeeDto.setEmployeeId(id);
        //then
        assertEquals(id,employeeDto.getEmployeeId());
    }

    @Test
    public void getFirstName() {
        String firstName = "first_name";
        employeeDto.setFirstName(firstName);
        assertEquals("first name not eq",firstName,employeeDto.getFirstName());
    }

    @Test
    public void getLastName() {
        String lastName = "last_name";
        employeeDto.setLastName(lastName);
        assertEquals("last name not eq",lastName,employeeDto.getLastName());
    }
}
