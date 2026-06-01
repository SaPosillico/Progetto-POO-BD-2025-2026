package implementazionePostgresDAO;

import dao.*;
import database.ConnessioneDatabase;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BigliettoImplementazionePostgresDAO implements BigliettoDAO {
    private Connection connection;

    public BigliettoImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserisciNuovoBiglietto(String codiceBiglietto, String idProiezione, String codicePosto, String idPagamento, String matricola, double prezzo) {
        String sql = "INSERT INTO \"Biglietto\" (\"codiceBiglietto\", \"prezzo\", \"matricola\", \"idPagamento\", \"codicePosto\", \"idProiezione\") VALUES (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1,codiceBiglietto);
            pr.setDouble(2,prezzo);
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
    public void recupperaBiglietti(ArrayList<Biglietto> elencoBiglietti) {
        String sql = "SELECT * FROM \"Biglietto\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
//                Biglietto b = new Biglietto();
//                elencoBiglietti.add(b);
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
