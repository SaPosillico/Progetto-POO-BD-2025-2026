package implementazionePostgresDAO;

import dao.RecensioneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecensioneImplementazionePostgresDAO implements RecensioneDAO {
    private Connection connection;
    @Override
    public void inserisciRecensione(String idFilm, String email, String descrizione, int valutazione) {
        String sql = "INSERT INTO \"Recensione\" (\"valutazione\", \"descrizione\", \"email\", \"idFilm\") VALUES (?, ?, ?, ?);";

        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setInt(1,valutazione);
            pr.setString(2,descrizione);
            pr.setString(3,email);
            pr.setString(4,idFilm);

            pr.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Errore nella query di inserimento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void recuperaRecensioni(ArrayList<String> idFilm, ArrayList<String> email, ArrayList<String> descrizione, ArrayList<Integer> valutazione) {
        String sql = "SELECT * FROM \"Recensione\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                idFilm.add(st.getString("idFilm"));
                email.add(st.getString("email"));
                descrizione.add(st.getString("descrizione"));
                valutazione.add(st.getInt("valutazione"));
            }
            st.close();
            connection.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
