package com.example.testapp.entity.dto;

import com.example.testapp.entity.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeDto {
    private Long employeeId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Gender Gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataOfBirth;
    public String jobTitle;
    private DepartmentDto department;

}
