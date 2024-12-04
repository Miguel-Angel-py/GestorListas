package com.miguel.GestionListas.Servicios;

import com.miguel.GestionListas.Modelo.ElementoModelo;
import com.miguel.GestionListas.Repositorios.ElementoRepositorio;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ElementoServicio {

    @Autowired
    private ElementoRepositorio elementoRepositorio;

    public List<ElementoModelo> devolverElementos() {
        return elementoRepositorio.findAll();
    }

    public ElementoModelo devolverElementoPorId(Integer Id) {
        try {

            return elementoRepositorio.findById(Id).get();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ResponseEntity<HttpStatus> crearElemento(ElementoModelo elemento) {
        try {

            elementoRepositorio.save(elemento);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<HttpStatus> borrarElemento(Integer Id) {
        try {

             elementoRepositorio.deleteById(Id);
             return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<HttpStatus> actualizarElemento(Integer Id, ElementoModelo elemento) {
        try {

            if(elementoRepositorio.existsById(Id)) {
                elementoRepositorio.deleteById(Id);
                elementoRepositorio.save(elemento);
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
