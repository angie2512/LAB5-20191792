package com.example.lab5.Controller;

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
        List<Jobs> listaTrabajos = jobsRepository.findAll();
        model.addAttribute("listaTrabajos",listaTrabajos);
        Long totalSalario = employeesRepository.getTotalSalaryByJobTitle("Puesto especificado");
        model.addAttribute("totalSalario", totalSalario);
        return "reportes/salario";
    }

    @GetMapping(value = "/tentativa")
    public String tentativa() {

        return "reportes/tentativa";
    }
}
