package com.miguel.GestionListas.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
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

    public ListaModelo getLista() {
        return lista;
    }

    public void setLista(ListaModelo lista) {
        this.lista = lista;
    }

    public ElementoModelo(String texto) {
        Texto = texto;
    }

    public ElementoModelo(ListaModelo lista, String texto) {
        this.lista = lista;
        Texto = texto;
    }
}
