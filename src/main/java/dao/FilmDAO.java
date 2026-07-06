package dao;

import java.util.ArrayList;

/**
 * The interface Film dao.
 */
public interface FilmDAO {
    /**
     * Definisce il metodo per inserire una nuova tupla di film sul database.
     *
     * @param titolo  il titolo del film
     * @param regista il regista
     * @param rating  il rating
     * @param genere  il genere
     */
    public void inserisciFilm(String titolo, String regista, String rating, String genere);

    /**
     * Recuppera i dati dei film dal database e li inserisce in degli ArrayList.
     *
     * @param idFilm  gli id dei film
     * @param titolo  i titoli
     * @param regista i registi
     * @param rating  i rating
     * @param genere  i generi
     */
    public void recuperaFilm(ArrayList<Integer> idFilm, ArrayList<String> titolo, ArrayList<String> regista, ArrayList<String> rating, ArrayList<String> genere);

    /**
     * Restituisce l'ultimo id dopo l'inserimento.
     *
     * @return the newest id
     */
    public int getNewestId();
}
