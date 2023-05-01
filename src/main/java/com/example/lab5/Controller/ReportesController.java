package com.example.lab5.Controller;

import com.example.lab5.DTO.SalariosDTO;
import com.example.lab5.Entity.Employees;
import com.example.lab5.Entity.Jobs;
import com.example.lab5.Repository.EmployeesRepository;
import com.example.lab5.Repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReportesController {

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = "/reportes")
    public String inicio() {

        return "reportes/reportes";
    }

    @GetMapping(value = "/salario")
    public String salario(Model model) {
        List<SalariosDTO> salariosDTO = employeesRepository.salariodto();
        model.addAttribute("salariosDTO",salariosDTO);
        return "reportes/salario";
    }

    @GetMapping(value = "/tentativa")
    public String tentativa() {

        return "reportes/tentativa";
    }
}
