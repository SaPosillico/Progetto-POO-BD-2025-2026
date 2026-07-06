package dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The interface Pagamento dao.
 */
public interface PagamentoDAO {
    /**
     * Definisce il metodo per inserire una nuova tupla di pagamento sul database.
     *
     * @param metodo  il metodo di pagamento
     * @param importo l'importo
     * @param data    la data
     * @param ora     l'ora
     * @param email   l'email del cliente
     */
    public void inserisciPagamento(String metodo, double importo, LocalDate data, LocalTime ora, String email);

    /**
     * Recuppera i dati dei pagamenti dal database e li inserisce in degli ArrayList.
     *
     * @param idPagamento gli id dei pagamenti
     * @param metodo      i metodi
     * @param importo     gli importi
     * @param data        le date
     * @param ora         le ore
     * @param email       le email
     */
    public void recuperaPagamenti(ArrayList<Integer> idPagamento, ArrayList<String> metodo, ArrayList<Double> importo, ArrayList<LocalDate> data, ArrayList<LocalTime> ora, ArrayList<String> email);

    /**
     * Restituisce l'ultimo id dopo l'inserimento.
     *
     * @return the newest id
     */
    public int getNewestId();
}
