package com.example.NutriAPP.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import com.example.NutriAPP.models.Visualizacion;
import com.example.NutriAPP.repositories.IVisualizacionRepositorio;

public class VisualizacionServicio {

    @Autowired 
     private  IVisualizacionRepositorio repositorio;

     //metodo para guardar un visualizacion
     public Visualizacion guardar(Visualizacion datos){

        return this.repositorio.save(datos);
     }

     public Visualizacion buscarPorId(UUID id){

        Optional<Visualizacion> visualizacionBucado=this.repositorio.findById(id);
        if (!visualizacionBucado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");
            

            
        }else{
            return visualizacionBucado.get();
        }
   
        }

    
}
