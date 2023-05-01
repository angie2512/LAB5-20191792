package com.example.lab5.Controller;

import com.example.lab5.Entity.Departments;
import com.example.lab5.Entity.Employees;
import com.example.lab5.Entity.Jobs;
import com.example.lab5.Repository.DepartmentsRepository;
import com.example.lab5.Repository.EmployeesRepository;
import com.example.lab5.Repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;

    @GetMapping(value = {"", "/lista"})
    public String listaEmployees(Model model) {
        List<Employees> listaEmpleados = employeesRepository.findAll();
        model.addAttribute("listaEmpleados",listaEmpleados);
        return "employees/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoEmpleado(@ModelAttribute("employees") Employees employees, Model model) {
        model.addAttribute("listaEmpleados", employeesRepository.findAll());
        model.addAttribute("listaPuestos", jobsRepository.findAll());
        model.addAttribute("listaDepartamentos", departmentsRepository.findAll());

        return "employees/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(Employees employees, RedirectAttributes attr, Model model) {


        if (employees.getEmployeeId() == 0) {
            attr.addFlashAttribute("msg", "Empleado creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Empleado actualizado exitosamente");
        }
        if (employees.getJob() != null) {
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            employees.setHireDate(timestamp);
            employees.setEnabled(1);
            employeesRepository.save(employees);
            return "redirect:/employees/lista";
        } else {
            model.addAttribute("errProd", "Error al crear empleado");
            model.addAttribute("listaEmpleados", employeesRepository.findAll());
            model.addAttribute("listaPuestos", jobsRepository.findAll());
            model.addAttribute("listaDepartamentos", departmentsRepository.findAll());
            if (employees.getEmployeeId() != 0) {
                model.addAttribute("employees", employees);
                return "redirect:/employees/lista";
            } else {
                return "employees/nuevo";
            }
        }
    }

    @PostMapping("/buscar")
    public String buscarEmployees(@RequestParam("buscando") String buscando,
                                      Model model) {

        List<Employees> listaEmployees = employeesRepository.buscarEmpleado(buscando);
        model.addAttribute("listaEmpleados", listaEmployees);

        return "employees/lista";
    }
    @GetMapping("/borrar")
    public String borrarEmpleado(Model model,
                                @RequestParam("id") int id,
                                RedirectAttributes attr) {

        Optional<Employees> optEmployee = employeesRepository.findById(id);

        if (optEmployee.isPresent()) {
            employeesRepository.deleteById(id);
            attr.addFlashAttribute("msg","Empleado borrado exitosamente");
        }
        return "redirect:/employees/lista";
    }
}