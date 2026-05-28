package dao;

import java.util.ArrayList;

public interface ClienteDAO {
    public void recuperaClienti(ArrayList<String> email, ArrayList<String> password, ArrayList<String> nome, ArrayList<String> cognome);
}
