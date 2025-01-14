package com.miguel.GestionListas.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Listas")
public class ListaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "Titulo")
    private String Titulo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lista")
    private List<ElementoModelo> elementos;

    public ListaModelo(String titulo, List<ElementoModelo> elementos) {
        Titulo = titulo;
        this.elementos = elementos;
    }

    public ListaModelo(String titulo) {
        Titulo = titulo;
    }

    public ListaModelo(){

    }
}
