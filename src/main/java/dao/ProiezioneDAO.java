package dao;

import java.util.ArrayList;

public interface ProiezioneDAO {
    public void inserisciProiezione(String data, String ora_inizio, String ora_fine, String idFilm);
    public void recuperaProiezioni(ArrayList<String> data, ArrayList<String> ora_inizio, ArrayList<String> ora_fine, ArrayList<String> idFilm);
}
