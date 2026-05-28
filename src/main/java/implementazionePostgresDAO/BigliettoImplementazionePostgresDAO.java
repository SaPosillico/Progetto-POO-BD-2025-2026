package implementazionePostgresDAO;

import dao.BigliettoDAO;
import database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BigliettoImplementazionePostgresDAO implements BigliettoDAO {
    private Connection connection;

    public BigliettoImplementazionePostgresDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void inserisciNuovoBiglietto(String codiceBiglietto, String idProiezione, String codicePosto, String idPagamento, String matricola, double prezzo) {
        String sql = "INSERT INTO \"Biglietto\" (\"codiceBiglietto\", \"prezzo\", \"matricola\", \"idPagamento\", \"codicePosto\", \"idProiezione\") VALUES (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1,codiceBiglietto);
            pr.setString(2,""+prezzo);
            pr.setString(3,matricola);
            pr.setString(4,idPagamento);
            pr.setString(5,codicePosto);
            pr.setString(6,idProiezione);
            pr.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Errore nella query di inserimento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void recupperaBiglietti(ArrayList<String> codiceBiglietto, ArrayList<String> idProiezione, ArrayList<String> codicePosto, ArrayList<Double> prezzo) {
        String sql = "SELECT * FROM \"Biglietto\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                codiceBiglietto.add(st.getString("codiceBiglietto"));
                idProiezione.add(st.getString("idProiezione"));
                codicePosto.add(st.getString("codicePosto"));
                prezzo.add(st.getDouble("prezzo"));
            }
            st.close();
            connection.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
