package dao;

import java.util.ArrayList;

public interface ClienteDAO {
    public void recuperaClienti(ArrayList<String> email, ArrayList<String> nome, ArrayList<String> cognome, ArrayList<String> password, ArrayList<String> tipo, ArrayList<Double> percentualeSconto);
}
