package implementazionePostgresDAO;

import dao.FilmDAO;
import model.Film;
import model.Genere;
import model.Rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmImplementazionePostgresDAO implements FilmDAO {
    private Connection connection;

    public FilmImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserisciFilm(String titolo, String regista, String rating, String genere) {
        String sql = "INSERT INTO \"Film\" (\"titolo\", \"regista\", \"genere\", \"rating\") VALUES (?, ?, ?, ?);";

        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1,titolo);
            pr.setString(2,regista);
            pr.setString(3,genere);
            pr.setString(4,rating);
            pr.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Errore nella query di inserimento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void recuperaFilm(ArrayList<Film> elencoFilm) {
        String sql = "SELECT * FROM \"Film\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                Film nuovoFilm = new Film(st.getString("titolo"),st.getString("regista"),Genere.valueOf(st.getString("genere")), Rating.valueOf(st.getString("rating")));
                elencoFilm.add(nuovoFilm);
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
