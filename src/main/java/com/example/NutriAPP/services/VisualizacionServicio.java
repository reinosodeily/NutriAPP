package com.example.NutriAPP.services;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.NutriAPP.models.Visualizacion;
import com.example.NutriAPP.repositories.IVisualizacionRepositorio;

public class VisualizacionServicio {

    @Autowired 
     private  IVisualizacionRepositorio repositorio;

     //metodo para guardar un visualizacion
     public Visualizacion guardar(Visualizacion datos){

        return this.repositorio.save(datos);
     }
}
