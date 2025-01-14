package com.miguel.GestionListas.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Table(name = "Elementos")
@Getter
@Setter
public class ElementoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name="Texto")
    private String Texto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lista_id")
    @JsonIgnore
    private ListaModelo lista;

    public ElementoModelo(String texto) {
        Texto = texto;
    }

    public ElementoModelo(ListaModelo lista, String texto) {
        this.lista = lista;
        Texto = texto;
    }
    public ElementoModelo(){

    }
}
