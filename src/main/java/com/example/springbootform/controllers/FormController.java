package com.example.springbootform.controllers;

import com.example.springbootform.controllers.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){

        model.addAttribute("titulo","Formulario de Usuario");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(Usuario usuario, Model model){


        model.addAttribute("usuario", usuario);
        return "resultado";
    }

}
