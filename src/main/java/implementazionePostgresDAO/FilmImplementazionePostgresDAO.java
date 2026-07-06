package implementazionePostgresDAO;

import dao.FilmDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Film implementazione postgres dao.
 */
public class FilmImplementazionePostgresDAO implements FilmDAO {
    private Connection connection;

    /**
     * Instantiates a new Film implementazione postgres dao.
     *
     * @param connection the connection
     */
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public void recuperaFilm(ArrayList<Integer> idFilm, ArrayList<String> titolo, ArrayList<String> regista, ArrayList<String> rating, ArrayList<String> genere) {
        String sql = "SELECT * FROM \"Film\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                idFilm.add(st.getInt("idFilm"));
                titolo.add(st.getString("titolo"));
                regista.add(st.getString("regista"));
                rating.add(st.getString("rating"));
                genere.add(st.getString("genere"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getNewestId() {
        String sql = "SELECT MAX(\"idFilm\") FROM \"Film\";";

        try{
            ResultSet st = connection.prepareStatement(sql).executeQuery();
            if(st.next())
                return  st.getInt("idFilm");
            return -1;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
