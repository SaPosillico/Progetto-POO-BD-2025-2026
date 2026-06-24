package dao;

import java.time.LocalTime;
import java.util.ArrayList;

public interface TurnoDAO {
    public void recuperaTurni(ArrayList<Integer> idTurno, ArrayList<LocalTime> oraInizio, ArrayList<LocalTime> oraFine, ArrayList<String> mansioni, ArrayList<Integer> matricola);
}
