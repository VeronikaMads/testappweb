package com.example.testapp.controller;

import com.example.testapp.dao.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final EmployeeService employeeService;

    @RequestMapping(value = {"", "/", "index", "index.html"})
    public String index() {
        System.out.println("test");
        return "index";
    }
}
