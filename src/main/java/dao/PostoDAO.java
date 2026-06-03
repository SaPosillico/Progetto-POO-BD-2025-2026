package dao;

import model.Posto;
import java.util.ArrayList;

public interface PostoDAO {
    public void recuperaPosti(ArrayList<String> codicePosto, ArrayList<Character> fila, ArrayList<Integer> numero, ArrayList<Integer> numeroSala);
}
