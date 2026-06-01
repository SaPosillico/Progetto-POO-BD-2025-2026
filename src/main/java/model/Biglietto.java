package model;

/**
 * The type Biglietto.
 */
public class Biglietto {
    private String codiceBiglietto;
    private double prezzo;
    private Posto numeroPosto;
    private Proiezione proiezioneRiferita;
    private Staff venditoreResponsabile;
    private Pagamento acquisto;

    /**
     * Instantiates a new Biglietto.
     *
     * @param codiceBiglietto       the codice biglietto
     * @param prezzo                the prezzo
     * @param numeroPosto           the numero posto
     * @param proiezioneRiferita    the proiezione riferita
     * @param venditoreResponsabile the venditore responsabile
     * @param acquisto              the acquisto
     */
    public Biglietto(String codiceBiglietto, double prezzo, Posto numeroPosto, Proiezione proiezioneRiferita, Staff venditoreResponsabile, Pagamento acquisto) {
        this.codiceBiglietto = codiceBiglietto;
        this.prezzo = prezzo;
        this.numeroPosto = numeroPosto;
        this.proiezioneRiferita = proiezioneRiferita;
        this.venditoreResponsabile = venditoreResponsabile;
        this.acquisto = acquisto;
    }

    /**
     * Gets codice biglietto.
     *
     * @return the codice biglietto
     */
    public String getCodiceBiglietto() {
        return codiceBiglietto;
    }

    /**
     * Sets codice biglietto.
     *
     * @param codiceBiglietto the codice biglietto
     */
    public void setCodiceBiglietto(String codiceBiglietto) {
        this.codiceBiglietto = codiceBiglietto;
    }

    /**
     * Gets prezzo.
     *
     * @return the prezzo
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * Sets prezzo.
     *
     * @param prezzo the prezzo
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Gets numero posto.
     *
     * @return the numero posto
     */
    public Posto getNumeroPosto() {
        return numeroPosto;
    }

    /**
     * Sets numero posto.
     *
     * @param numeroPosto the numero posto
     */
    public void setNumeroPosto(Posto numeroPosto) {
        this.numeroPosto = numeroPosto;
    }

    /**
     * Gets proiezione riferita.
     *
     * @return the proiezione riferita
     */
    public Proiezione getProiezioneRiferita() {
        return proiezioneRiferita;
    }

    /**
     * Sets proiezione riferita.
     *
     * @param proiezioneRiferita the proiezione riferita
     */
    public void setProiezioneRiferita(Proiezione proiezioneRiferita) {
        this.proiezioneRiferita = proiezioneRiferita;
    }

    /**
     * Gets venditore responsabile.
     *
     * @return the venditore responsabile
     */
    public Staff getVenditoreResponsabile() {
        return venditoreResponsabile;
    }

    /**
     * Sets venditore responsabile.
     *
     * @param venditoreResponsabile the venditore responsabile
     */
    public void setVenditoreResponsabile(Staff venditoreResponsabile) {
        this.venditoreResponsabile = venditoreResponsabile;
    }

    /**
     * Gets acquisto.
     *
     * @return the acquisto
     */
    public Pagamento getAcquisto() {
        return acquisto;
    }

    /**
     * Sets acquisto.
     *
     * @param acquisto the acquisto
     */
    public void setAcquisto(Pagamento acquisto) {
        this.acquisto = acquisto;
    }

    @Override
    public String toString() {
        return "Codice: "+codiceBiglietto +", Prezzo: "+ prezzo +", Posto: "+ numeroPosto.getNumeroPosto();
    }
}
