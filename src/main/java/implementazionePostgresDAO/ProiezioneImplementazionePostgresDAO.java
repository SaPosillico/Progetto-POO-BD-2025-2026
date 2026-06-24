package implementazionePostgresDAO;

import dao.ProiezioneDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ProiezioneImplementazionePostgresDAO implements ProiezioneDAO {
    private Connection connection;

    public ProiezioneImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserisciProiezione(LocalDate data, LocalTime ora_inizio, LocalTime ora_fine, int idFilm, int numeroSala){
        String sql = "INSERT INTO \"Proiezione\" (\"data\", \"ora_inizio\", \"ora_fine\", \"idFilm\",\"numeroSala\") VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setObject(1,data);
            pr.setObject(2,ora_inizio);
            pr.setObject(3,ora_fine);
            pr.setInt(4,idFilm);
            pr.setInt(5,numeroSala);

            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void recuperaProiezioni(ArrayList<Integer> idProiezione, ArrayList<LocalDate> data, ArrayList<LocalTime> ora_inizio, ArrayList<LocalTime> ora_fine, ArrayList<Integer> idFilm, ArrayList<Integer> numeroSala) {
        String sql = "SELECT * FROM \"Proiezione\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                idProiezione.add(st.getInt("idProiezione"));
                LocalDate dataProiezione = st.getObject("data", LocalDate.class);
                LocalTime ora1 = st.getObject("ora_inizio", LocalTime.class);
                LocalTime ora2 = st.getObject("ora_fine", LocalTime.class);
                data.add(dataProiezione);
                ora_inizio.add(ora1);
                ora_fine.add(ora2);
                idFilm.add(st.getInt("idFilm"));
                numeroSala.add(st.getInt("numeroSala"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
