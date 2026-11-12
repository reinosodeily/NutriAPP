package com.example.NutriAPP.models;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "visualizaciones")
public class Visualizacion {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "fecha_visualizacion", nullable = false)
    private LocalDate fecha_visualizacion;

    @Column(name = "completado", nullable = false)
    private Boolean completado;
    
    @ManyToOne 
    @JoinColumn (name = "id")
    @JsonManagedReference (value = "video-visualizacion")
    private Usuario usuario;

    @ManyToOne 
    @JoinColumn (name = "id")
     @JsonManagedReference (value = "video-visualizacion")
    private Video video;
    //creado una  realcion
 public Visualizacion() {
 }

 public Visualizacion(UUID id, LocalDate fecha_visualizacion, Boolean completado) {
    this.id = id;
    this.fecha_visualizacion = fecha_visualizacion;
    this.completado = completado;
 }

 public UUID getId() {
    return id;
 }

 public void setId(UUID id) {
    this.id = id;
 }

 public LocalDate getFecha_visualizacion() {
    return fecha_visualizacion;
 }

 public void setFecha_visualizacion(LocalDate fecha_visualizacion) {
    this.fecha_visualizacion = fecha_visualizacion;
 }

 public Boolean getCompletado() {
    return completado;
 }

 public void setCompletado(Boolean completado) {
    this.completado = completado;
 }

 
}
