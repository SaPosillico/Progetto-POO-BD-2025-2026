package dao;

import java.util.ArrayList;

/**
 * The interface Sala dao.
 */
public interface SalaDAO {
    /**
     * Recuppera i dati delle sale dal database e li inserisce in degli ArrayList.
     *
     * @param numeroSala i numeri di sala
     * @param capienza   le capienza
     */
    public void recuperaSale(ArrayList<Integer> numeroSala, ArrayList<Integer> capienza);

    /**
     * Recupera i dati dello staff e delle sale dell'associazione (*..*).
     *
     * @param numeroMatricola le matricola
     * @param numeroSala      i numeri di sala
     */
    public void recuperaDatiStaffSAle(ArrayList<Integer> numeroMatricola, ArrayList<Integer> numeroSala);
}
