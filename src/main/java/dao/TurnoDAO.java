package dao;

import java.util.ArrayList;

public interface TurnoDAO {
    public void recuperaTurni(ArrayList<String> ora_inizio, ArrayList<String> ora_fine, ArrayList<String> matricola);
}
