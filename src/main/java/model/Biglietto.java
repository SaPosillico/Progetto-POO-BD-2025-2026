package model;

public class Biglietto {
    private int codiceBiglietto;
    private double prezzo;
    private Posto numeroPosto;
    private Proiezione proiezioneRiferita;
    private Staff venditoreResponsabile;
    private Pagamento acquisto;

    public Biglietto(int codiceBiglietto, double prezzo, Posto numeroPosto, Proiezione proiezioneRiferita, Staff venditoreResponsabile, Pagamento acquisto) {
        this.codiceBiglietto = codiceBiglietto;
        this.prezzo = prezzo;
        this.numeroPosto = numeroPosto;
        this.proiezioneRiferita = proiezioneRiferita;
        this.venditoreResponsabile = venditoreResponsabile;
        this.acquisto = acquisto;
    }

    public int getCodiceBiglietto() {
        return codiceBiglietto;
    }

    public void setCodiceBiglietto(int codiceBiglietto) {
        this.codiceBiglietto = codiceBiglietto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Posto getNumeroPosto() {
        return numeroPosto;
    }

    public void setNumeroPosto(Posto numeroPosto) {
        this.numeroPosto = numeroPosto;
    }

    public Proiezione getProiezioneRiferita() {
        return proiezioneRiferita;
    }

    public void setProiezioneRiferita(Proiezione proiezioneRiferita) {
        this.proiezioneRiferita = proiezioneRiferita;
    }

    public Staff getVenditoreResponsabile() {
        return venditoreResponsabile;
    }

    public void setVenditoreResponsabile(Staff venditoreResponsabile) {
        this.venditoreResponsabile = venditoreResponsabile;
    }

    public Pagamento getAcquisto() {
        return acquisto;
    }

    public void setAcquisto(Pagamento acquisto) {
        this.acquisto = acquisto;
    }

    @Override
    public String toString() {
        return "Codice: "+codiceBiglietto +", Prezzo: "+ prezzo +", Posto: "+ numeroPosto.getNumeroPosto();
    }
}
