package com.example.NutriAPP.models;

import java.util.UUID;

import com.example.NutriAPP.models.helpers.Departamento;
import com.example.NutriAPP.models.helpers.Rol;

public class Usuario {
 
     private UUID id;
    private String nombre;
    private String correo;
    private Rol rol;
    private Departamento departamento;
    
    public Usuario() {
    }

    public Usuario(UUID id, String nombre, String correo, Rol rol, Departamento departamento) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.departamento = departamento;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    


}
