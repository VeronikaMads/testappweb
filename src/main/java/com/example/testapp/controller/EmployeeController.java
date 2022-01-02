package com.example.testapp.controller;

import com.example.testapp.dao.service.EmployeeService;
import com.example.testapp.entity.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/employees")
@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("/index")
    public String getEmployees(Model model) {
        Collection<EmployeeDto> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/index";
    }

    @GetMapping("/{id}")
    public ModelAndView showEmployee(@PathVariable(name = "id") Long employeeId) {
        ModelAndView modelAndView = new ModelAndView("employees/employeeDetails");
        EmployeeDto employeeDto = employeeService.findById(employeeId);
        modelAndView.addObject("employee", employeeDto);
        return modelAndView;
    }

    @GetMapping("/find")
    public String findEmployees(Model model) {
        model.addAttribute("employee", EmployeeDto.builder().build());
        return "employees/findEmployees";
    }

    @GetMapping
    public String processFindEmployees(EmployeeDto dto, Model model) {
        List<EmployeeDto> result = employeeService.findEmployee(dto);
        model.addAttribute("selections", result);
        return "employees/employeesList";
    }
}
