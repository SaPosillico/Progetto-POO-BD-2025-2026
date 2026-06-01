package implementazionePostgresDAO;

import dao.TurnoDAO;
import model.Turno;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

public class TurnoImplementazionePostgresDAO implements TurnoDAO {
    private Connection connection;

    public TurnoImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void recuperaTurni(ArrayList<Turno> turni) {
        String sql = "SELECT * FROM \"Turno\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
//                ora_inizio.add((LocalTime) st.getObject("ora_inizio"));
//                ora_fine.add((LocalTime) st.getObject("ora_fine"));
//                matricola.add(st.getString("matricola"));
//                mansione.add(st.getString("mansioni"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
