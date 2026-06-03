package dao;

import model.Recensione;
import model.Sala;

import java.util.ArrayList;

public interface RecensioneDAO {
    public void inserisciRecensione(int idFilm, String email, String descrizione, int valutazione);
    public void recuperaRecensioni(ArrayList<Integer> idRecensione, ArrayList<Integer> idFilm, ArrayList<String> email, ArrayList<String> descrizione, ArrayList<Integer> valutazione);
}
