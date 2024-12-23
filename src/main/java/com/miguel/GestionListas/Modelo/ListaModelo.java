package com.miguel.GestionListas.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
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

    public Integer getId() {
        return Id;
    }

    public List<ElementoModelo> getElementos() {
        return elementos;
    }

    public void setElementos(List<ElementoModelo> elementos) {
        this.elementos = elementos;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public ListaModelo(String titulo, List<ElementoModelo> elementos) {
        Titulo = titulo;
        this.elementos = elementos;
    }

    public ListaModelo(String titulo) {
        Titulo = titulo;
    }
}
