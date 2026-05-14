package model;

import java.util.ArrayList;

public class Posto {
    private int codicePosto;
    private char fila;
    private int numeroPosto;
    private Sala numeroSala;
    private ArrayList<Biglietto> bigliettiAssociati;

    public Posto(int codicePosto, char fila, int numeroPosto, Sala numeroSala) {
        this.codicePosto = codicePosto;
        this.fila = fila;
        this.numeroPosto = numeroPosto;
        this.numeroSala = numeroSala;
        this.bigliettiAssociati = new ArrayList<>();
    }

    public int getCodicePosto() {
        return codicePosto;
    }

    public void setCodicePosto(int codicePosto) {
        this.codicePosto = codicePosto;
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public int getNumeroPosto() {
        return numeroPosto;
    }

    public void setNumeroPosto(int numeroPosto) {
        this.numeroPosto = numeroPosto;
    }

    public Sala getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Sala numeroSala) {
        this.numeroSala = numeroSala;
    }

    public ArrayList<Biglietto> getBigliettiAssociati() {
        return bigliettiAssociati;
    }

    public void setBigliettiAssociati(ArrayList<Biglietto> bigliettiAssociati) {
        this.bigliettiAssociati = bigliettiAssociati;
    }

    public void addBiglietto(Biglietto biglietto) {
        this.bigliettiAssociati.add(biglietto);
    }
}
