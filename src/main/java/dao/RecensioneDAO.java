package dao;

import model.Recensione;
import java.util.ArrayList;

public interface RecensioneDAO {
    public void inserisciRecensione(String idFilm, String email, String descrizione, int valutazione);
    public void recuperaRecensioni(ArrayList<Recensione> elencoRecensioni);
}
