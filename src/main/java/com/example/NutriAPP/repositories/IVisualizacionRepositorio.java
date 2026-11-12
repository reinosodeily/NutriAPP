package com.example.NutriAPP.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.NutriAPP.models.Visualizacion;

public interface IVisualizacionRepositorio extends JpaRepository<Visualizacion,UUID>{

    List<Visualizacion> findByFecha_visualizacion(LocalDate fecha_visualizacion);
    
    
    List<Visualizacion> findByCompletadoFalse();
    
    
    List<Visualizacion> findByCompletadoTrue();

}
