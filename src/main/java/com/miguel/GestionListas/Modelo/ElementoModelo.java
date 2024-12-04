package com.miguel.GestionListas.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Elementos")
public class ElementoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name="Texto")
    private String Texto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lista_id")
    private ListaModelo lista;

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }
}
