package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The type Proiezione.
 */
public class Proiezione {
    private LocalDate dataProiezione;
    private LocalTime oraInizioProiezione;
    private LocalTime oraFineProiezione;
    private Sala salaProiezione;
    private Film filmProiettato;
    private ArrayList<Biglietto> bigliettiVenduti;

    /**
     * Instantiates a new Proiezione.
     *
     * @param dataProiezione      the data proiezione
     * @param oraInizioProiezione the ora inizio proiezione
     * @param oraFineProiezione   the ora fine proiezione
     * @param salaProiezione      the sala proiezione
     * @param filmProiettato      the film proiettato
     */
    public Proiezione(LocalDate dataProiezione, LocalTime oraInizioProiezione, LocalTime oraFineProiezione, Sala salaProiezione, Film filmProiettato) {
        this.dataProiezione = dataProiezione;
        this.oraInizioProiezione = oraInizioProiezione;
        this.oraFineProiezione = oraFineProiezione;
        this.salaProiezione = salaProiezione;
        this.filmProiettato = filmProiettato;
        this.bigliettiVenduti = new ArrayList<>();
    }

    /**
     * Gets data proiezione.
     *
     * @return the data proiezione
     */
    public LocalDate getDataProiezione() {
        return dataProiezione;
    }

    /**
     * Sets data proiezione.
     *
     * @param dataProiezione the data proiezione
     */
    public void setDataProiezione(LocalDate dataProiezione) {
        this.dataProiezione = dataProiezione;
    }

    /**
     * Gets ora inizio proiezione.
     *
     * @return the ora inizio proiezione
     */
    public LocalTime getOraInizioProiezione() {
        return oraInizioProiezione;
    }

    /**
     * Sets ora inizio proiezione.
     *
     * @param oraInizioProiezione the ora inizio proiezione
     */
    public void setOraInizioProiezione(LocalTime oraInizioProiezione) {
        this.oraInizioProiezione = oraInizioProiezione;
    }

    /**
     * Gets ora fine proiezione.
     *
     * @return the ora fine proiezione
     */
    public LocalTime getOraFineProiezione() {
        return oraFineProiezione;
    }

    /**
     * Sets ora fine proiezione.
     *
     * @param oraFineProiezione the ora fine proiezione
     */
    public void setOraFineProiezione(LocalTime oraFineProiezione) {
        this.oraFineProiezione = oraFineProiezione;
    }

    /**
     * Gets sala proiezione.
     *
     * @return the sala proiezione
     */
    public Sala getSalaProiezione() {
        return salaProiezione;
    }

    /**
     * Sets sala proiezione.
     *
     * @param salaProiezione the sala proiezione
     */
    public void setSalaProiezione(Sala salaProiezione) {
        this.salaProiezione = salaProiezione;
    }

    /**
     * Gets film proiettato.
     *
     * @return the film proiettato
     */
    public Film getFilmProiettato() {
        return filmProiettato;
    }

    /**
     * Sets film proiettato.
     *
     * @param filmProiettato the film proiettato
     */
    public void setFilmProiettato(Film filmProiettato) {
        this.filmProiettato = filmProiettato;
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
     * Add biglietto.
     *
     * @param biglietto the biglietto
     */
    public void addBiglietto(Biglietto biglietto) {
        this.bigliettiVenduti.add(biglietto);
    }
}
