package dao;

import java.util.ArrayList;

public interface RecensioneDAO {
    public void inserisciRecensione(String idFilm, String email, String descrizione, int valutazione);
    public void recuperaRecensioni(ArrayList<String> idFilm, ArrayList<String> email, ArrayList<String> descrizione, ArrayList<Integer> valutazione);
}
