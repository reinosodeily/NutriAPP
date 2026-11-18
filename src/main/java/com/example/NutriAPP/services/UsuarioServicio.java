package com.example.NutriAPP.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
     
        //metodo de busqueda por id
     public Usuario buscarPorId(UUID id){

        Optional<Usuario> usuarioBucado=this.repositorio.findById(id);
        if (!usuarioBucado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");


            
        }else{
            return usuarioBucado.get();
        }
   
        }

        //metodo para modificar 
        public Usuario modificar(UUID id, Usuario datos){

            Optional<Usuario> usuarioBucado=this.repositorio.findById(id);
        if (!usuarioBucado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");


            
        }else{
            
            //precargar la info que existe actualmente en BD
            Usuario usuarioEncontrado =usuarioBucado.get();

            usuarioEncontrado.setNombre(datos.getNombre());
            usuarioBucado.setRol(datos.getRol());

            //espacio para vorver aguardar el usuario que se acaba de modificar 
            return this.repositorio.save(usuarioEncontrado); 
        }

        }

}
