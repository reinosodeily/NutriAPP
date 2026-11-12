package com.example.NutriAPP.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NutriAPP.models.Usuario;
import com.example.NutriAPP.models.helpers.Departamento;
import com.example.NutriAPP.models.helpers.Rol;

 
    @Repository 
    public  interface IUsuarioRepositorio extends JpaRepository<Usuario,UUID>{

        //consultas prefabricadas (BUSCAR)
        //1. buscar un usuario asociado a un departameto y especifico
        List<Usuario> findByDepartamentoAndRol(String departamento, String rol);

        Optional<Usuario> findByCorreo(String correo);

        List<Usuario> findByRolOrderByNombreAsc(String rol);

        Boolean existsByCorreo(String correo);
        
    }
    
        
    

