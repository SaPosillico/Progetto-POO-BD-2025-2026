package model;

import java.util.ArrayList;

/**
 * The type Posto.
 */
public class Posto {
    private int codicePosto;
    private char fila;
    private int numeroPosto;
    private Sala numeroSala;
    private ArrayList<Biglietto> bigliettiAssociati;

    /**
     * Instantiates a new Posto.
     *
     * @param codicePosto the codice posto
     * @param fila        the fila
     * @param numeroPosto the numero posto
     * @param numeroSala  the numero sala
     */
    public Posto(int codicePosto, char fila, int numeroPosto, Sala numeroSala) {
        this.codicePosto = codicePosto;
        this.fila = fila;
        this.numeroPosto = numeroPosto;
        this.numeroSala = numeroSala;
        this.bigliettiAssociati = new ArrayList<>();
    }

    /**
     * Gets codice posto.
     *
     * @return the codice posto
     */
    public int getCodicePosto() {
        return codicePosto;
    }

    /**
     * Sets codice posto.
     *
     * @param codicePosto the codice posto
     */
    public void setCodicePosto(int codicePosto) {
        this.codicePosto = codicePosto;
    }

    /**
     * Gets fila.
     *
     * @return the fila
     */
    public char getFila() {
        return fila;
    }

    /**
     * Sets fila.
     *
     * @param fila the fila
     */
    public void setFila(char fila) {
        this.fila = fila;
    }

    /**
     * Gets numero posto.
     *
     * @return the numero posto
     */
    public int getNumeroPosto() {
        return numeroPosto;
    }

    /**
     * Sets numero posto.
     *
     * @param numeroPosto the numero posto
     */
    public void setNumeroPosto(int numeroPosto) {
        this.numeroPosto = numeroPosto;
    }

    /**
     * Gets numero sala.
     *
     * @return the numero sala
     */
    public Sala getNumeroSala() {
        return numeroSala;
    }

    /**
     * Sets numero sala.
     *
     * @param numeroSala the numero sala
     */
    public void setNumeroSala(Sala numeroSala) {
        this.numeroSala = numeroSala;
    }

    /**
     * Gets biglietti associati.
     *
     * @return the biglietti associati
     */
    public ArrayList<Biglietto> getBigliettiAssociati() {
        return bigliettiAssociati;
    }

    /**
     * Sets biglietti associati.
     *
     * @param bigliettiAssociati the biglietti associati
     */
    public void setBigliettiAssociati(ArrayList<Biglietto> bigliettiAssociati) {
        this.bigliettiAssociati = bigliettiAssociati;
    }

    /**
     * Add biglietto.
     *
     * @param biglietto the biglietto
     */
    public void addBiglietto(Biglietto biglietto) {
        this.bigliettiAssociati.add(biglietto);
    }
}
