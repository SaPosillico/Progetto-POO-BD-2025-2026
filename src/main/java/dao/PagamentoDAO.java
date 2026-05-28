package dao;

import java.util.ArrayList;

public interface PagamentoDAO {
    public void inserisciPagamento(String metodo, double importo, String data, String ora, String email);
    public void recuperaPagamenti(ArrayList<String> metodo, ArrayList<Double> importo, ArrayList<String> data, ArrayList<String> ora);
}
