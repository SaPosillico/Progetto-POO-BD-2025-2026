package dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The interface Proiezione dao.
 */
public interface ProiezioneDAO {
    /**
     * Definisce il metodo per inserire una nuova tupla di proiezione sul database.
     *
     * @param data       la data
     * @param ora_inizio l'ora d'inizio
     * @param ora_fine   l'ora di fine
     * @param idFilm     l'id del film
     * @param numeroSala il numero della sala
     */
    public void inserisciProiezione(LocalDate data, LocalTime ora_inizio, LocalTime ora_fine, int idFilm, int numeroSala);

    /**
     * Recuppera i dati delle proiezioni dal database e li inserisce in degli ArrayList.
     *
     * @param idProiezione gli id delle proiezioni
     * @param data         le date
     * @param ora_inizio   le ore d'inizio
     * @param ora_fine     le ore di fine
     * @param idFilm       gli id dei film
     * @param numeroSala   i numeri di sala
     */
    public void recuperaProiezioni(ArrayList<Integer> idProiezione, ArrayList<LocalDate> data, ArrayList<LocalTime> ora_inizio, ArrayList<LocalTime> ora_fine, ArrayList<Integer> idFilm, ArrayList<Integer> numeroSala);

    /**
     * Restituisce l'ultimo id dopo l'inserimento di una nuova proiezione.
     *
     * @return the newest id
     */
    public int getNewestId();
}
