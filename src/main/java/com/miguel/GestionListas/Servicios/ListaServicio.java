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

    public ResponseEntity<HttpStatus> crearLista(ListaModelo lista) {
        return listaRepositorio.save(lista);
    }

    public ResponseEntity<HttpStatus> borrarLista(Integer Id) {
        return listaRepositorio.deleteById(Id);
    }

    public ResponseEntity<HttpStatus> actualizarLista(Integer Id, ListaModelo listaNueva) {
        if(listaRepositorio.existsById(Id)){
            listaRepositorio.deleteById(Id);
            listaRepositorio.save(listaNueva);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ListaModelo devolverListaPorId(Integer id) {
    }
}
