package com.example.NutriAPP.services;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.NutriAPP.models.Video;
import com.example.NutriAPP.repositories.IVideoRepositorio;

public class VideoServicio {
@Autowired 
     private  IVideoRepositorio repositorio;

     //metodo para guardar un video
     public Video guardar(Video datos){

        return this.repositorio.save(datos);
     }
}
