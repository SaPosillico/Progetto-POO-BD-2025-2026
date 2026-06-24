package dao;

import java.util.ArrayList;

public interface StaffDAO {
    public void recuperaStaff(ArrayList<Integer> matricola, ArrayList<String> nome, ArrayList<String> cognome, ArrayList<Double> stipendio);
}
