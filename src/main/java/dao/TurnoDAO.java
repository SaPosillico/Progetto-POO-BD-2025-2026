package dao;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The interface Turno dao.
 */
public interface TurnoDAO {
    /**
     * Recuppera i dati dei turni dal database e li inserisce in degli ArrayList.
     *
     * @param idTurno   l'id del turno
     * @param oraInizio l'ora d'inizio
     * @param oraFine   l'ora di fine
     * @param mansioni  le mansioni
     * @param matricola la matricola
     */
    public void recuperaTurni(ArrayList<Integer> idTurno, ArrayList<LocalTime> oraInizio, ArrayList<LocalTime> oraFine, ArrayList<String> mansioni, ArrayList<Integer> matricola);
}
