package com.example.springbootform.validation;

import com.example.springbootform.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// Usamos Component para que se pueda validar luego en el controlador y haga su función
@Component
public class UsuarioValidation implements Validator {

    //Sirve para validar el objeto que queramos, en este caso Usuario
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;
        ValidationUtils.rejectIfEmpty(errors,"nombre","NotEmpty.usuario.nombre");

        if (!usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")){
            errors.rejectValue("identificador", "Pattern.usuario.identificador");
        };
    }
}
