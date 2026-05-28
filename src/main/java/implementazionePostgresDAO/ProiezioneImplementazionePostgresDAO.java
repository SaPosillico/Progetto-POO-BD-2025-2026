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
    @Override
    public void inserisciProiezione(LocalDate data, LocalTime ora_inizio, LocalTime ora_fine, int idFilm) {
        String sql = "INSERT INTO \"Proiezione\" (\"data\", \"ora_inizio\", \"ora_fine\", \"idFilm\") VALUES (?, ?, ?, ?);";

        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setObject(1,data);
            pr.setObject(2,ora_inizio);
            pr.setObject(3,ora_fine);
            pr.setInt(4,idFilm);

            pr.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Errore nella query di inserimento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void recuperaProiezioni(ArrayList<LocalDate> data, ArrayList<LocalTime> ora_inizio, ArrayList<LocalTime> ora_fine, ArrayList<Integer> idFilm) {
        String sql = "SELECT * FROM \"Proiezione\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                LocalDate dataProiezione = st.getObject("data", LocalDate.class);
                LocalTime ora1 = st.getObject("ora_inizio", LocalTime.class);
                LocalTime ora2 = st.getObject("ora_fine", LocalTime.class);
                data.add(dataProiezione);
                ora_inizio.add(ora1);
                ora_fine.add(ora2);
                idFilm.add(st.getInt("idFilm"));
            }
            st.close();
            connection.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
