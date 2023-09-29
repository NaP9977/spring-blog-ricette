package org.learning.ricette.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name="ricette")
public class Ricetta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titolo;

    private String listaIngredienti;

    private String url;
    private LocalTime tempo;
    private Integer porzioni;

    private String testoRicetta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getListaIngredienti() {
        return listaIngredienti;
    }

    public void setListaIngredienti(String listaIngredienti) {
        this.listaIngredienti = listaIngredienti;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalTime tempo) {
        this.tempo = tempo;
    }

    public Integer getPorzioni() {
        return porzioni;
    }

    public void setPorzioni(Integer porzioni) {
        this.porzioni = porzioni;
    }

    public String getTestoRicetta() {
        return testoRicetta;
    }

    public void setTestoRicetta(String testoRicetta) {
        this.testoRicetta = testoRicetta;
    }
}
