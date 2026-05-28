package dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface ProiezioneDAO {
    public void inserisciProiezione(LocalDate data, LocalTime ora_inizio, LocalTime ora_fine, int idFilm);
    public void recuperaProiezioni(ArrayList<LocalDate> data, ArrayList<LocalTime> ora_inizio, ArrayList<LocalTime> ora_fine, ArrayList<Integer> idFilm);
}
