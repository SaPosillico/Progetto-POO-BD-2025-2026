package model;

import java.util.ArrayList;

/**
 * The type Staff.
 */
public class Staff {
    private int matricola;
    private String nome;
    private String cognome;
    private double stipendio;
    private ArrayList<Turno> turniEffettuati;
    private ArrayList<Sala> salePulite;
    private ArrayList<Biglietto> bigliettiVenduti;

    /**
     * Instantiates a new Staff.
     *
     * @param matricola la matricola
     * @param nome      il nome
     * @param cognome   il cognome
     * @param stipendio lo stipendio
     */
    public Staff(int matricola, String nome, String cognome, double stipendio) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.stipendio = stipendio;
        this.turniEffettuati = new ArrayList<>();
        this.salePulite = new ArrayList<>();
        this.bigliettiVenduti = new ArrayList<>();
    }

    /**
     * Gets matricola.
     *
     * @return the matricola
     */
    public int getMatricola() {
        return matricola;
    }

    /**
     * Sets matricola.
     *
     * @param matricola the matricola
     */
    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets cognome.
     *
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Sets cognome.
     *
     * @param cognome the cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Gets stipendio.
     *
     * @return the stipendio
     */
    public double getStipendio() {
        return stipendio;
    }

    /**
     * Sets stipendio.
     *
     * @param stipendio the stipendio
     */
    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    /**
     * Gets turni effettuati.
     *
     * @return the turni effettuati
     */
    public ArrayList<Turno> getTurniEffettuati() {
        return turniEffettuati;
    }

    /**
     * Sets turni effettuati.
     *
     * @param turniEffettuati the turni effettuati
     */
    public void setTurniEffettuati(ArrayList<Turno> turniEffettuati) {
        this.turniEffettuati = turniEffettuati;
    }

    /**
     * Gets sale pulite.
     *
     * @return the sale pulite
     */
    public ArrayList<Sala> getSalePulite() {
        return salePulite;
    }

    /**
     * Sets sale pulite.
     *
     * @param salePulite the sale pulite
     */
    public void setSalePulite(ArrayList<Sala> salePulite) {
        this.salePulite = salePulite;
    }

    /**
     * Gets biglietti venduti.
     *
     * @return the biglietti venduti
     */
    public ArrayList<Biglietto> getBigliettiVenduti() {
        return bigliettiVenduti;
    }

    /**
     * Sets biglietti venduti.
     *
     * @param bigliettiVenduti the biglietti venduti
     */
    public void setBigliettiVenduti(ArrayList<Biglietto> bigliettiVenduti) {
        this.bigliettiVenduti = bigliettiVenduti;
    }

    /**
     * Add turni effettuati.
     *
     * @param turno the turno
     */
    public void addTurniEffettuati(Turno turno) {
        this.turniEffettuati.add(turno);
    }

    /**
     * Add sala.
     *
     * @param sala the sala
     */
    public void addSala(Sala sala) {
        this.salePulite.add(sala);
    }

    /**
     * Add biglietto.
     *
     * @param biglietto the biglietto
     */
    public void addBiglietto(Biglietto biglietto) {
        this.bigliettiVenduti.add(biglietto);
    }
}
