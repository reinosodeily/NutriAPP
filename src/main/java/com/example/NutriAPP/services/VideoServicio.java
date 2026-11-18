package com.example.NutriAPP.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutriAPP.models.Usuario;
import com.example.NutriAPP.models.Video;
import com.example.NutriAPP.repositories.IVideoRepositorio;

public class VideoServicio {
@Autowired 
     private  IVideoRepositorio repositorio;

     //metodo para guardar un video
     public Video guardar(Video datos){

        return this.repositorio.save(datos);
     }

     public Video buscarPorId(UUID id){

        Optional<Video> videoBucado=this.repositorio.findById(id);
        if (!videoBucado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");
            

            
        }else{
            return videoBucado.get();
        }
  
        }

        public Video modificar(UUID id, Video datos){

            Optional<Video> usuarioBucado=this.repositorio.findById(id);
        if (!usuarioBucado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");


            
        }else{
            
            //precargar la info que existe actualmente en BD
            Video videoEncontrado =videoBucado.get();
            //espacio para modificar solo los propiedades permitidos 
            videoEncontrado.setTitulo(datos.getTitulo());
            videoEncontrado.setCategoria(datos.getCategoria());

            //espacio para vorver aguardar el usuario que se acaba de modificar 
            return this.repositorio.save(videoEncontrado);
        }

        }

        public boolean eliminar (UUID id){

             Optional<Video> videoBucado=this.repositorio.findById(id);
        if (!videoBucado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");
            

            
        }else{
            this.repositorio.deleteById(id);
            return true;
        }
        }
}
