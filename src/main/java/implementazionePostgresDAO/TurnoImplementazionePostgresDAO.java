package implementazionePostgresDAO;

import dao.TurnoDAO;
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
    public void recuperaTurni(ArrayList<Integer> idTurno, ArrayList<LocalTime> oraInizio, ArrayList<LocalTime> oraFine, ArrayList<String> mansioni, ArrayList<Integer> matricola) {
        String sql = "SELECT * FROM \"Turno\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                idTurno.add(st.getInt("idTurno"));
                oraInizio.add(st.getObject("ora_inizio", LocalTime.class));
                oraFine.add(st.getObject("ora_fine", LocalTime.class));
                matricola.add(st.getInt("matricola"));
                mansioni.add(st.getString("mansioni"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
