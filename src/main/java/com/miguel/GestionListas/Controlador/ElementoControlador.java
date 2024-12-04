package com.miguel.GestionListas.Controlador;

import com.miguel.GestionListas.Modelo.ElementoModelo;
import com.miguel.GestionListas.Servicios.ElementoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/elemento")
public class ElementoControlador {

    @Autowired
    private ElementoServicio elementoServicio;

    @GetMapping
    public List<ElementoModelo> getElementos(){
        return elementoServicio.getElementos();
    }
}
