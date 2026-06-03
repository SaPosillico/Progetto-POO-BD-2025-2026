package dao;

import model.Film;
import java.util.ArrayList;

public interface FilmDAO {
    public void inserisciFilm(String titolo, String regista, String rating, String genere);
    public void recuperaFilm(ArrayList<Integer> idFilm, ArrayList<String> titolo, ArrayList<String> regista, ArrayList<String> rating, ArrayList<String> genere);
}
