package implementazionePostgresDAO;

import dao.*;
import controller.*;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Biglietto implementazione postgres dao.
 */
public class BigliettoImplementazionePostgresDAO implements BigliettoDAO {
    private Connection connection;

    /**
     * Instantiates a new Biglietto implementazione postgres dao.
     *
     * @param connection the connection
     */
    public BigliettoImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserisciNuovoBiglietto(String codiceBiglietto, int idProiezione, String codicePosto, int idPagamento, Integer matricola, double prezzo) {
        String sql = "INSERT INTO \"Biglietto\" (\"codiceBiglietto\", \"prezzo\", \"matricola\", \"idPagamento\", \"codicePosto\", \"idProiezione\") VALUES (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1,codiceBiglietto);
            pr.setDouble(2,prezzo);
            if (matricola==null) {
                pr.setNull(3, java.sql.Types.INTEGER);
            } else {
                pr.setInt(3, matricola);
            }
            pr.setInt(4,idPagamento);
            pr.setString(5,codicePosto);
            pr.setInt(6,idProiezione);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void recupperaBiglietti(ArrayList<String> codiceBiglietto, ArrayList<Integer> idProiezione, ArrayList<String> codicePosto, ArrayList<Integer> idPagamento, ArrayList<Integer> matricola, ArrayList<Double> prezzo) {
        String sql = "SELECT * FROM \"Biglietto\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                codiceBiglietto.add(st.getString("codiceBiglietto"));
                prezzo.add(st.getDouble("prezzo"));
                int mat = st.getInt("matricola");
                if (st.wasNull()) {
                    matricola.add(Controller.VENDITA_ONLINE.getMatricola());
                } else {
                    matricola.add(mat);
                }
                idPagamento.add(st.getInt("idPagamento"));
                codicePosto.add(st.getString("codicePosto"));
                idProiezione.add(st.getInt("idProiezione"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
