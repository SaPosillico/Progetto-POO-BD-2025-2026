package model;

import java.util.ArrayList;

public class Sala {
    private int numeroSala;
    private int capienza;
    private ArrayList <Posto> postiPresenti;
    private ArrayList<Proiezione> proiezioniEseguite;
    private ArrayList<Staff> staffDiSala;

    public Sala(int numeroSala, int capienza) {
        this.numeroSala = numeroSala;
        this.capienza = capienza;
        this.postiPresenti = new ArrayList<>();
        this.proiezioniEseguite = new ArrayList<>();
        this.staffDiSala = new ArrayList<>();
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public ArrayList<Posto> getPostiPresenti() {
        return postiPresenti;
    }

    public void setPostiPresenti(ArrayList<Posto> postiPresenti) {
        this.postiPresenti = postiPresenti;
    }

    public ArrayList<Proiezione> getProiezioniEseguite() {
        return proiezioniEseguite;
    }

    public void setProiezioniEseguite(ArrayList<Proiezione> proiezioniEseguite) {
        this.proiezioniEseguite = proiezioniEseguite;
    }

    public ArrayList<Staff> getStaffDiSala() {
        return staffDiSala;
    }

    public void setStaffDiSala(ArrayList<Staff> staffDiSala) {
        this.staffDiSala = staffDiSala;
    }

    public void addProiezione(Proiezione proiezione) {
        this.proiezioniEseguite.add(proiezione);
    }

    public void addStaffDiSala(Staff staffDiSala) {
        this.staffDiSala.add(staffDiSala);
    }

    public void addPostiPresenti(Posto posti) {
        this.postiPresenti.add(posti);
    }
}
