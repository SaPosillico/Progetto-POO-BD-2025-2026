package dao;


import model.Biglietto;
import java.util.ArrayList;

public interface BigliettoDAO {
    public void inserisciNuovoBiglietto(String codiceBiglietto, int idProiezione, String codicePosto, int idPagamento, Integer matricola, double prezzo);
    public void recupperaBiglietti(ArrayList<String> codiceBiglietto, ArrayList<Integer> idProiezione, ArrayList<String> codicePosto, ArrayList<Integer> idPagamento, ArrayList<Integer> matricola, ArrayList<Double> prezzo);
}
