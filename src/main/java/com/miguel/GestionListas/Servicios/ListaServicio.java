package com.miguel.GestionListas.Servicios;

import com.miguel.GestionListas.Modelo.ListaModelo;
import com.miguel.GestionListas.Repositorios.ListaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaServicio {

    @Autowired
    private ListaRepositorio listaRepositorio;
    public List<ListaModelo> devolverListas() {
        return listaRepositorio.findAll();
    }

    public ListaModelo devolverListaPorId(Integer id) {
        try{
            return listaRepositorio.findById(id).get();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ResponseEntity<HttpStatus> crearLista(ListaModelo lista) {
        try{
            listaRepositorio.save(lista);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<HttpStatus> borrarLista(Integer Id) {
        try{
        listaRepositorio.deleteById(Id);
        return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<HttpStatus> actualizarLista(Integer Id, ListaModelo listaNueva) {
        try {
            if (listaRepositorio.existsById(Id)) {
                listaRepositorio.deleteById(Id);
                listaRepositorio.save(listaNueva);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
