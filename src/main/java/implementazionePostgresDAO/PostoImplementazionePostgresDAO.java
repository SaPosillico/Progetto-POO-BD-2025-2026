package implementazionePostgresDAO;

import dao.PostoDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostoImplementazionePostgresDAO implements PostoDAO {
    private Connection connection;

    public PostoImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void recuperaPosti(ArrayList<String> codicePosto, ArrayList<Character> fila, ArrayList<Integer> numero, ArrayList<Integer> numeroSala) {
        String sql = "SELECT * FROM \"Posto\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                String filaStr = st.getString("fila");
                char carattereFila = (filaStr != null && !filaStr.isEmpty()) ? filaStr.charAt(0) : ' ';
                fila.add(carattereFila);
                numero.add(st.getInt("numero"));
                codicePosto.add(st.getString("codicePosto"));
                numeroSala.add(st.getInt("numeroSala"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
