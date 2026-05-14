package model;

import java.util.ArrayList;

public class Staff {
    private int matricola;
    private String nome;
    private String cognome;
    private double stipendio;
    private ArrayList<Turno> turniEffettuati;
    private ArrayList<Sala> salePulite;
    private ArrayList<Biglietto> bigliettiVenduti;

    public Staff(int matricola, String nome, String cognome, double stipendio) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.stipendio = stipendio;
        this.turniEffettuati = new ArrayList<>();
        this.salePulite = new ArrayList<>();
        this.bigliettiVenduti = new ArrayList<>();
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public ArrayList<Turno> getTurniEffettuati() {
        return turniEffettuati;
    }

    public void setTurniEffettuati(ArrayList<Turno> turniEffettuati) {
        this.turniEffettuati = turniEffettuati;
    }

    public ArrayList<Sala> getSalePulite() {
        return salePulite;
    }

    public void setSalePulite(ArrayList<Sala> salePulite) {
        this.salePulite = salePulite;
    }

    public ArrayList<Biglietto> getBigliettiVenduti() {
        return bigliettiVenduti;
    }

    public void setBigliettiVenduti(ArrayList<Biglietto> bigliettiVenduti) {
        this.bigliettiVenduti = bigliettiVenduti;
    }

    public void addTurniEffettuati(Turno turno) {
        this.turniEffettuati.add(turno);
    }

    public void addSala(Sala sala) {
        this.salePulite.add(sala);
    }

    public void addBiglietto(Biglietto biglietto) {
        this.bigliettiVenduti.add(biglietto);
    }
}
