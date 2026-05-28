package implementazionePostgresDAO;

import dao.TurnoDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TurnoImplementazionePostgresDAO implements TurnoDAO {
    private Connection connection;;
    @Override
    public void recuperaTurni(ArrayList<String> ora_inizio, ArrayList<String> ora_fine, ArrayList<String> matricola, ArrayList<String> mansione) {
        String sql = "SELECT * FROM \"Turno\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                ora_inizio.add(st.getString("ora_inizio"));
                ora_fine.add(st.getString("ora_fine"));
                matricola.add(st.getString("matricola"));
                mansione.add(st.getString("mansioni"));
            }
            st.close();
            connection.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
