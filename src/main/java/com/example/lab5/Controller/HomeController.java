package com.example.lab5.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/inicio")
    public String inicio() {

        return "vistas/traveltrip";
    }
}
