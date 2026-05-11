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
}
