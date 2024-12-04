package com.miguel.GestionListas.Repositorios;

import com.miguel.GestionListas.Modelo.ListaModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaRepositorio extends JpaRepository<ListaModelo, Integer> {
}
