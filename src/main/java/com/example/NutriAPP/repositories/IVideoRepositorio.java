package com.example.NutriAPP.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.NutriAPP.models.Video;
import com.example.NutriAPP.models.helpers.Categoria;

public interface IVideoRepositorio extends JpaRepository<Video,UUID>{

    List<Video> findByCategoria(Categoria categoria);
    
    
    List<Video> findByTituloIgnoreCase(String titulo);
    
   
    List<Video> findByDescripcionContainingIgnoreCase(String descripcion);
    
    
    List<Video> findByUrl(String url);
    
    
    List<Video> findByTituloIgnoreCaseAndCategoria(String titulo, Categoria categoria);

}
