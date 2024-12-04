package com.miguel.GestionListas.Servicios;

import com.miguel.GestionListas.Modelo.ElementoModelo;
import com.miguel.GestionListas.Repositorios.ElementoRepositorio;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ElementoServicio {

    @Autowired
    private ElementoRepositorio elementoRepositorio;

    public List<ElementoModelo> getElementos() {
        return elementoRepositorio.findAll();
    }
}
