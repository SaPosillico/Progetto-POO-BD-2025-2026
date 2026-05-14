package model;

import java.util.ArrayList;

public class Film {
    private String titolo;
    private String regista;
    private Genere genere;
    private Rating rating;
    private ArrayList<Recensione> recensioni;
    private ArrayList<Proiezione> proiezioni;

    public Film(String titolo, String regista, Genere genere, Rating rating) {
        this.titolo = titolo;
        this.regista = regista;
        this.genere = genere;
        this.rating = rating;
        this.recensioni = new ArrayList<>();
        this.proiezioni = new ArrayList<>();
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public ArrayList<Recensione> getRecensioni() {
        return recensioni;
    }

    public void setRecensioni(ArrayList<Recensione> recensioni) {
        this.recensioni = recensioni;
    }

    public ArrayList<Proiezione> getProiezioni() {
        return proiezioni;
    }

    public void setProiezioni(ArrayList<Proiezione> proiezioni) {
        this.proiezioni = proiezioni;
    }

    public void addProiezione(Proiezione p) {
        this.proiezioni.add(p);
    }

    public void addRecensione(Recensione r) {
        this.recensioni.add(r);
    }
}
