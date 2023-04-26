package com.example.lab5.Controller;

import com.example.lab5.Entity.Employees;
import com.example.lab5.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = "/inicio")
    public String inicio() {

        return "vistas/traveltrip";
    }

    @GetMapping("/lista")
    public String lista(Model model) {
        List<Employees> listaEmployees = employeesRepository.findAll(); //listatodo
        model.addAttribute("listaEmployees", listaEmployees);
        return "vistas/lista";
    }
}
