package com.miguel.GestionListas.Controlador;

import com.miguel.GestionListas.Modelo.ElementoModelo;
import com.miguel.GestionListas.Servicios.ElementoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elemento")
public class ElementoControlador {

    @Autowired
    private ElementoServicio elementoServicio;

    @GetMapping
    public List<ElementoModelo> devolverElementos(){
        return elementoServicio.devolverElementos();
    }

    @GetMapping("/{Id}")
    public ElementoModelo devolverElementoById(@PathVariable Integer Id){
        return elementoServicio.devolverElementoPorId(Id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> crearElemento(@RequestBody ElementoModelo elemento){
        return elementoServicio.crearElemento(elemento);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<HttpStatus> borrarElemento(@PathVariable Integer Id){
        return elementoServicio.borrarElemento(Id);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<HttpStatus> actualizarElemento(@PathVariable Integer Id, @RequestBody ElementoModelo elemento){
        return elementoServicio.actualizarElemento(Id, elemento);
    }
}
