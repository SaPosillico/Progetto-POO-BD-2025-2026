package dao;

import java.util.ArrayList;

/**
 * The interface Recensione dao.
 */
public interface RecensioneDAO {
    /**
     * Definisce il metodo per inserire una nuova tupla di recensione sul database.
     *
     * @param idFilm      l'id del film
     * @param email       l'email del cliente
     * @param descrizione la descrizione fornita
     * @param valutazione la valutazione data
     */
    public void inserisciRecensione(int idFilm, String email, String descrizione, int valutazione);

    /**
     * Recuppera i dati delle recensioni dal database e li inserisce in degli ArrayList.
     *
     * @param idRecensione gli id delle recensione
     * @param idFilm       gli id dei film
     * @param email        le email
     * @param descrizione  le descrizioni
     * @param valutazione  le valutazioni
     */
    public void recuperaRecensioni(ArrayList<Integer> idRecensione, ArrayList<Integer> idFilm, ArrayList<String> email, ArrayList<String> descrizione, ArrayList<Integer> valutazione);

    /**
     * Restituisce l'ultimo id dopo l'inserimenti di una nuova recensione.
     *
     * @return the newest id
     */
    public int getNewestId();
}
