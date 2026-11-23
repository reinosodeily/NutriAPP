package com.example.NutriAPP.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutriAPP.models.Usuario;
import com.example.NutriAPP.repositories.IUsuarioRepositorio;

public class VsualizacionValidacion {
 @Autowired
    private IUsuarioRepositorio repositorio;

    //Validaciones de formato

    //1. validar que un campo sea obligatorio
    public void validarTextoObligatorio(String valor, String campo){
        if(valor==null || valor.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El campo "+campo+" es obligatorio");
        }
    }

    //2. validar la longitud de un nombre
    public void validarNombre(String nombre){  
        if(nombre.trim().length()<3 || nombre.trim().length()>100){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El nombre debe tener entre 3 y 100 caracteres");
        }
    }

    //3. EXPRESIONES REGULARES PARA VALIDAR QUE UN CORREO SI SEA UN CORREO 
    //algo@algo.algo
    public void validarCorreo(String correo){
        if(!correo.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.]+$")){
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El correo no cumple el formato esperado");

        }
    }

    ////4. validar que la contraseña tenga minimo 8 caracteres
    public void validarContraseña(String contraseña){
        if(contraseña.length()< 8){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La contarseña debe ser mas grande de 8 caracteres");
        }
        
    }


    //Validaciones del negocio

    //1. Validar que el correo de un usuario que se quiere registrar no exista en la BD
    public void validarUsuarioNuevo(Usuario datos){
        String correoEntregado=datos.getCorreo();
        if(this.repositorio.existsByCorreo(correoEntregado)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El correo entregado ya existe en BD");

        }
    }
}
