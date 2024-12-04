package com.miguel.GestionListas.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Listas")
public class ListaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "Titulo")
    private String Titulo;

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
}
