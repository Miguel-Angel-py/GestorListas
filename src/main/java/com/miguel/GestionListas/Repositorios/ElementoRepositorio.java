package com.miguel.GestionListas.Repositorios;

import com.miguel.GestionListas.Modelo.ElementoModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementoRepositorio extends JpaRepository<ElementoModelo, Integer> {
}
