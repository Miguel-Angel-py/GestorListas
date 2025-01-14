package com.miguel.GestionListas.Controlador;

import com.miguel.GestionListas.Modelo.ListaModelo;
import com.miguel.GestionListas.Servicios.ListaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lista")
public class ListaControlador {

    @Autowired
    private ListaServicio listaServicio;

    @GetMapping
    public List<ListaModelo> devolverListas(){
       return listaServicio.devolverListas();
    }

    @GetMapping("/{Id}")
    public ListaModelo devolverListaPorId(@PathVariable Integer Id){
        return listaServicio.devolverListaPorId(Id);
    }

    @PostMapping("/crear")
    public ResponseEntity<HttpStatus> crearLista(@RequestBody ListaModelo lista){
        return listaServicio.crearLista(lista);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<HttpStatus> borrarLista(@PathVariable Integer Id){
        return listaServicio.borrarLista(Id);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<HttpStatus> actualizarLista(@RequestBody ListaModelo listaNueva, @PathVariable Integer Id){
        return listaServicio.actualizarLista(Id, listaNueva);
    }
}
