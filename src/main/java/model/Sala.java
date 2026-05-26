package model;

import java.util.ArrayList;

/**
 * The type Sala.
 */
public class Sala {
    private int numeroSala;
    private int capienza;
    private ArrayList <Posto> postiPresenti;
    private ArrayList<Proiezione> proiezioniEseguite;
    private ArrayList<Staff> staffDiSala;

    /**
     * Instantiates a new Sala.
     *
     * @param numeroSala the numero sala
     * @param capienza   the capienza
     */
    public Sala(int numeroSala, int capienza) {
        this.numeroSala = numeroSala;
        this.capienza = capienza;
        this.postiPresenti = new ArrayList<>();
        this.proiezioniEseguite = new ArrayList<>();
        this.staffDiSala = new ArrayList<>();
    }

    /**
     * Gets numero sala.
     *
     * @return the numero sala
     */
    public int getNumeroSala() {
        return numeroSala;
    }

    /**
     * Sets numero sala.
     *
     * @param numeroSala the numero sala
     */
    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    /**
     * Gets capienza.
     *
     * @return the capienza
     */
    public int getCapienza() {
        return capienza;
    }

    /**
     * Sets capienza.
     *
     * @param capienza the capienza
     */
    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    /**
     * Gets posti presenti.
     *
     * @return the posti presenti
     */
    public ArrayList<Posto> getPostiPresenti() {
        return postiPresenti;
    }

    /**
     * Sets posti presenti.
     *
     * @param postiPresenti the posti presenti
     */
    public void setPostiPresenti(ArrayList<Posto> postiPresenti) {
        this.postiPresenti = postiPresenti;
    }

    /**
     * Gets proiezioni eseguite.
     *
     * @return the proiezioni eseguite
     */
    public ArrayList<Proiezione> getProiezioniEseguite() {
        return proiezioniEseguite;
    }

    /**
     * Sets proiezioni eseguite.
     *
     * @param proiezioniEseguite the proiezioni eseguite
     */
    public void setProiezioniEseguite(ArrayList<Proiezione> proiezioniEseguite) {
        this.proiezioniEseguite = proiezioniEseguite;
    }

    /**
     * Gets staff di sala.
     *
     * @return the staff di sala
     */
    public ArrayList<Staff> getStaffDiSala() {
        return staffDiSala;
    }

    /**
     * Sets staff di sala.
     *
     * @param staffDiSala the staff di sala
     */
    public void setStaffDiSala(ArrayList<Staff> staffDiSala) {
        this.staffDiSala = staffDiSala;
    }

    /**
     * Add proiezione.
     *
     * @param proiezione the proiezione
     */
    public void addProiezione(Proiezione proiezione) {
        this.proiezioniEseguite.add(proiezione);
    }

    /**
     * Add staff di sala.
     *
     * @param staffDiSala the staff di sala
     */
    public void addStaffDiSala(Staff staffDiSala) {
        this.staffDiSala.add(staffDiSala);
    }

    /**
     * Add posti presenti.
     *
     * @param posti the posti
     */
    public void addPostiPresenti(Posto posti) {
        this.postiPresenti.add(posti);
    }
}
