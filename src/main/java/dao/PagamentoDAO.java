package dao;

import model.Pagamento;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface PagamentoDAO {
    public void inserisciPagamento(String metodo, double importo, LocalDate data, LocalTime ora, String email);
    public void recuperaPagamenti(ArrayList<Integer> idPagamento, ArrayList<String> metodo, ArrayList<Double> importo, ArrayList<LocalDate> data, ArrayList<LocalTime> ora, ArrayList<String> email);
    public int getNewestId();
}
