package dao;

import java.util.ArrayList;

/**
 * The interface Biglietto dao.
 */
public interface BigliettoDAO {
    /**
     * Definisce il metodo per inserire una nuova tupla di biglietto sul database.
     *
     * @param codiceBiglietto il codice delbiglietto
     * @param idProiezione    l'id della proiezione
     * @param codicePosto     il codice del posto
     * @param idPagamento     l'id del pagamento
     * @param matricola       la matricola del responsabile alla vendita
     * @param prezzo          il prezzo del biglietto
     */
    public void inserisciNuovoBiglietto(String codiceBiglietto, int idProiezione, String codicePosto, int idPagamento, Integer matricola, double prezzo);

    /**
     * Recuppera i dati dei biglietti dal database e li inserisce in degli ArrayList.
     *
     * @param codiceBiglietto i codici dei biglietti
     * @param idProiezione    gli id delle proiezioni
     * @param codicePosto     i codici dei posti
     * @param idPagamento     gli id dei pagamenti
     * @param matricola       le matricole
     * @param prezzo          i prezzi dei biglietti
     */
    public void recupperaBiglietti(ArrayList<String> codiceBiglietto, ArrayList<Integer> idProiezione, ArrayList<String> codicePosto, ArrayList<Integer> idPagamento, ArrayList<Integer> matricola, ArrayList<Double> prezzo);
}
