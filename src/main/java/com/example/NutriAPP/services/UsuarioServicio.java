package com.example.NutriAPP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NutriAPP.models.Usuario;
import com.example.NutriAPP.repositories.IUsuarioRepositorio;

@Service 
public class UsuarioServicio {

     // para cociar ececito la receta 
     // para prgramar los cervicios ecesito los repositorios 

     // inyeccio de depedecias 
    @Autowired 
     private  IUsuarioRepositorio repositorio;

     //metodo para guardar un usuario
     public Usuario guardar(Usuario datos){

        return this.repositorio.save(datos);
     }


}
