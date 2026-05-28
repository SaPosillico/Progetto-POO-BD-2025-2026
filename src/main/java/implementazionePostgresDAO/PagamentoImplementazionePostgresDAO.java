package implementazionePostgresDAO;

import dao.PagamentoDAO;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PagamentoImplementazionePostgresDAO implements PagamentoDAO {
    private Connection connection;
    @Override
    public void inserisciPagamento(String metodo, double importo, LocalDate data, LocalTime ora, String email) {
        String sql = "INSERT INTO \"Pagamento\" (\"metodo\", \"importo\", \"data\", \"ora\", \"email\") VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1,metodo);
            pr.setDouble(2,importo);
            pr.setObject(3,data);
            pr.setObject(4,ora);
            pr.setString(5,email);
            pr.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Errore nella query di inserimento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void recuperaPagamenti(ArrayList<String> metodo, ArrayList<Double> importo, ArrayList<LocalDate> data, ArrayList<LocalTime> ora) {
        String sql = "SELECT * FROM \"Pagamento\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                metodo.add(st.getString("metodo"));
                LocalDate dataPagamento = st.getObject("data_proiezione", LocalDate.class);
                LocalTime orario = st.getObject("ora_inizio", LocalTime.class);
                data.add(dataPagamento);
                ora.add(orario);
                importo.add(st.getDouble("importo"));
            }
            st.close();
            connection.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
