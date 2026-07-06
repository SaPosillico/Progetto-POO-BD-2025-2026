package dao;

import java.util.ArrayList;

/**
 * The interface Staff dao.
 */
public interface StaffDAO {
    /**
     * Recuppera i dati dello staff dal database e li inserisce in degli ArrayList.
     *
     * @param matricola la matricola
     * @param nome      il nome
     * @param cognome   il cognome
     * @param stipendio lo stipendio
     */
    public void recuperaStaff(ArrayList<Integer> matricola, ArrayList<String> nome, ArrayList<String> cognome, ArrayList<Double> stipendio);
}
