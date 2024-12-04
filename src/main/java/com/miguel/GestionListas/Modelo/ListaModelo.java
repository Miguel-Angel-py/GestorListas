package com.miguel.GestionListas.Modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Listas")
public class ListaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "Titulo")
    private String Titulo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lista")
    private List<ElementoModelo> elementos;

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
}
