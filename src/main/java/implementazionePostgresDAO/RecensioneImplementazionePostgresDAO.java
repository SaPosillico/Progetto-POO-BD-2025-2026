package implementazionePostgresDAO;

import dao.RecensioneDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Recensione implementazione postgres dao.
 */
public class RecensioneImplementazionePostgresDAO implements RecensioneDAO {
    private Connection connection;

    /**
     * Instantiates a new Recensione implementazione postgres dao.
     *
     * @param connection the connection
     */
    public RecensioneImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserisciRecensione(int idFilm, String email, String descrizione, int valutazione) {
        String sql = "INSERT INTO \"Recensione\" (\"valutazione\", \"descrizione\", \"email\", \"idFilm\") VALUES (?, ?, ?, ?);";

        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setInt(1,valutazione);
            pr.setString(2,descrizione);
            pr.setString(3,email);
            pr.setInt(4,idFilm);

            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void recuperaRecensioni(ArrayList<Integer> idRecensione, ArrayList<Integer> idFilm, ArrayList<String> email, ArrayList<String> descrizione, ArrayList<Integer> valutazione) {
        String sql = "SELECT * FROM \"Recensione\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                idRecensione.add(st.getInt("idRecensione"));
                idFilm.add(st.getInt("idFilm"));
                email.add(st.getString("email"));
                descrizione.add(st.getString("descrizione"));
                valutazione.add(st.getInt("valutazione"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getNewestId() {
        String sql = "SELECT MAX(\"idRecensione\") FROM \"Recensione\";";

        try{
            ResultSet st = connection.prepareStatement(sql).executeQuery();
            if(st.next())
                return  st.getInt("idRecensione");
            return -1;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
