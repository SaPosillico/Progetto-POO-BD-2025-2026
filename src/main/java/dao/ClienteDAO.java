package dao;

import java.util.ArrayList;

/**
 * The interface Cliente dao.
 */
public interface ClienteDAO {
    /**
     * Recuppera i dati dei clienti dal database e li inserisce in degli ArrayList.
     *
     * @param email             le email
     * @param nome              i nomi
     * @param cognome           i cognomi
     * @param password          le password
     * @param tipo              i tipi
     * @param percentualeSconto le percentuali sconto
     */
    public void recuperaClienti(ArrayList<String> email, ArrayList<String> nome, ArrayList<String> cognome, ArrayList<String> password, ArrayList<String> tipo, ArrayList<Double> percentualeSconto);
}
