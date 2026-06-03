package dao;


import model.Biglietto;
import java.util.ArrayList;

public interface BigliettoDAO {
    public void inserisciNuovoBiglietto(String codiceBiglietto, String idProiezione, String codicePosto, String idPagamento, String matricola, double prezzo);
    public void recupperaBiglietti(ArrayList<String> codiceBiglietto, ArrayList<Integer> idProiezione, ArrayList<String> codicePosto, ArrayList<Integer> idPagamento, ArrayList<Integer> matricola, ArrayList<Double> prezzo);
}
