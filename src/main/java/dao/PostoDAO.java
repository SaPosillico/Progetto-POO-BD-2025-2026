package dao;

import java.util.ArrayList;

/**
 * The interface Posto dao.
 */
public interface PostoDAO {
    /**
     * Recuppera i dati dei posti dal database e li inserisce in degli ArrayList.
     *
     * @param codicePosto i codici dei posti
     * @param fila        le file
     * @param numero      i numeri
     * @param numeroSala  i numeri di sala
     */
    public void recuperaPosti(ArrayList<String> codicePosto, ArrayList<Character> fila, ArrayList<Integer> numero, ArrayList<Integer> numeroSala);
}
