package dao;

import model.Proiezione;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface ProiezioneDAO {
    public void inserisciProiezione(LocalDate data, LocalTime ora_inizio, LocalTime ora_fine, int idFilm);
    public void recuperaProiezioni(ArrayList<Proiezione> elencoProiezioni);
}
