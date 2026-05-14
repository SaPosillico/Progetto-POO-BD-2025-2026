package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Proiezione {
    private LocalDate dataProiezione;
    private LocalTime oraInizioProiezione;
    private LocalTime oraFineProiezione;
    private Sala salaProiezione;
    private Film filmProiettato;
    private ArrayList<Biglietto> bigliettiVenduti;

    public Proiezione(LocalDate dataProiezione, LocalTime oraInizioProiezione, LocalTime oraFineProiezione, Sala salaProiezione, Film filmProiettato) {
        this.dataProiezione = dataProiezione;
        this.oraInizioProiezione = oraInizioProiezione;
        this.oraFineProiezione = oraFineProiezione;
        this.salaProiezione = salaProiezione;
        this.filmProiettato = filmProiettato;
        this.bigliettiVenduti = new ArrayList<>();
    }

    public LocalDate getDataProiezione() {
        return dataProiezione;
    }

    public void setDataProiezione(LocalDate dataProiezione) {
        this.dataProiezione = dataProiezione;
    }

    public LocalTime getOraInizioProiezione() {
        return oraInizioProiezione;
    }

    public void setOraInizioProiezione(LocalTime oraInizioProiezione) {
        this.oraInizioProiezione = oraInizioProiezione;
    }

    public LocalTime getOraFineProiezione() {
        return oraFineProiezione;
    }

    public void setOraFineProiezione(LocalTime oraFineProiezione) {
        this.oraFineProiezione = oraFineProiezione;
    }

    public Sala getSalaProiezione() {
        return salaProiezione;
    }

    public void setSalaProiezione(Sala salaProiezione) {
        this.salaProiezione = salaProiezione;
    }

    public Film getFilmProiettato() {
        return filmProiettato;
    }

    public void setFilmProiettato(Film filmProiettato) {
        this.filmProiettato = filmProiettato;
    }

    public ArrayList<Biglietto> getBigliettiVenduti() {
        return bigliettiVenduti;
    }

    public void setBigliettiVenduti(ArrayList<Biglietto> bigliettiVenduti) {
        this.bigliettiVenduti = bigliettiVenduti;
    }

    public void addBiglietto(Biglietto biglietto) {
        this.bigliettiVenduti.add(biglietto);
    }
}
