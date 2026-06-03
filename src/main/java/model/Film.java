package model;

import java.util.ArrayList;

/**
 * The type Film.
 */
public class Film {
    private int idFilm;
    private String titolo;
    private String regista;
    private Genere genere;
    private Rating rating;
    private ArrayList<Recensione> recensioni;
    private ArrayList<Proiezione> proiezioni;

    /**
     * Instantiates a new Film.
     *
     * @param titolo  the titolo
     * @param regista the regista
     * @param genere  the genere
     * @param rating  the rating
     */
    public Film(int idFilm,String titolo, String regista, Genere genere, Rating rating) {
        this.idFilm = idFilm;
        this.titolo = titolo;
        this.regista = regista;
        this.genere = genere;
        this.rating = rating;
        this.recensioni = new ArrayList<>();
        this.proiezioni = new ArrayList<>();
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    /**
     * Gets titolo.
     *
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Sets titolo.
     *
     * @param titolo the titolo
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * Gets regista.
     *
     * @return the regista
     */
    public String getRegista() {
        return regista;
    }

    /**
     * Sets regista.
     *
     * @param regista the regista
     */
    public void setRegista(String regista) {
        this.regista = regista;
    }

    /**
     * Gets genere.
     *
     * @return the genere
     */
    public Genere getGenere() {
        return genere;
    }

    /**
     * Sets genere.
     *
     * @param genere the genere
     */
    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    /**
     * Gets recensioni.
     *
     * @return the recensioni
     */
    public ArrayList<Recensione> getRecensioni() {
        return recensioni;
    }

    /**
     * Sets recensioni.
     *
     * @param recensioni the recensioni
     */
    public void setRecensioni(ArrayList<Recensione> recensioni) {
        this.recensioni = recensioni;
    }

    /**
     * Gets proiezioni.
     *
     * @return the proiezioni
     */
    public ArrayList<Proiezione> getProiezioni() {
        return proiezioni;
    }

    /**
     * Sets proiezioni.
     *
     * @param proiezioni the proiezioni
     */
    public void setProiezioni(ArrayList<Proiezione> proiezioni) {
        this.proiezioni = proiezioni;
    }

    /**
     * Add proiezione.
     *
     * @param p the p
     */
    public void addProiezione(Proiezione p) {
        this.proiezioni.add(p);
    }

    /**
     * Add recensione.
     *
     * @param r the r
     */
    public void addRecensione(Recensione r) {
        this.recensioni.add(r);
    }
}
