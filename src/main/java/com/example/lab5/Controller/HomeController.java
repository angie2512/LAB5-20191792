package com.example.lab5.Controller;

import com.example.lab5.Entity.Employees;
import com.example.lab5.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {


    @GetMapping(value = "/inicio")
    public String inicio() {

        return "/traveltrip";
    }



}
