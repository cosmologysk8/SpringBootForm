package com.example.springbootform.controllers;

import com.example.springbootform.model.Usuario;
import com.example.springbootform.validation.UsuarioValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


// SessionAttributes sirve para mantener los datos, como ejemplo tenemos el identificador le damos un valor
// pero no en el formulario si no cuando le das a submit para que luego salga el identificador
@SessionAttributes("usuario")
@Controller
public class FormController {

    @Autowired
    private UsuarioValidation validation;
    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();
        usuario.setIdentificador("737-525-K");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo","Formulario de Usuario");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status){

        validation.validate(usuario, result);

        if(result.hasErrors()){
//            Map<String, String> errores = new HashMap<>();
//            result.getFieldErrors().forEach(err ->{
//                errores.put(err.getField(), "El campo :".concat(
//                        err.getField().concat(" ")
//                                .concat(err.getDefaultMessage())));
//            });
//            model.addAttribute("error", errores);
            return "form";
        }
        model.addAttribute("usuario", usuario);
        // setComplete() elimina de forma automatica el objeto usuario de la sesion
        status.setComplete();
        return "resultado";
    }

}
