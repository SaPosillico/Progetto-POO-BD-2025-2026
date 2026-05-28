package dao;


import java.util.ArrayList;

public interface BigliettoDAO {
    public void inserisciNuovoBiglietto(String codiceBiglietto, String idProiezione, String codicePosto, String idPagamento, String matricola, double prezzo);
    public void recupperaBiglietti(ArrayList<String> codiceBiglietto, ArrayList<String> idProiezione, ArrayList<String> codicePosto,ArrayList<Double> prezzo);
}
