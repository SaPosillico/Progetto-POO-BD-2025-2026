package implementazionePostgresDAO;

import dao.PagamentoDAO;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The type Pagamento implementazione postgres dao.
 */
public class PagamentoImplementazionePostgresDAO implements PagamentoDAO {
    private Connection connection;

    /**
     * Instantiates a new Pagamento implementazione postgres dao.
     *
     * @param connection the connection
     */
    public PagamentoImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

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
            throw new RuntimeException(e);
        }
    }

    @Override
    public void recuperaPagamenti(ArrayList<Integer> idPagamento, ArrayList<String> metodo, ArrayList<Double> importo, ArrayList<LocalDate> data, ArrayList<LocalTime> ora, ArrayList<String> email) {
        String sql = "SELECT * FROM \"Pagamento\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                idPagamento.add(st.getInt("idPagamento"));
                metodo.add(st.getString("metodo"));
                LocalDate dataPagamento = st.getObject("data", LocalDate.class);
                LocalTime orario = st.getObject("ora", LocalTime.class);
                data.add(dataPagamento);
                ora.add(orario);
                importo.add(st.getDouble("importo"));
                email.add(st.getString("email"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getNewestId() {
        String sql = "SELECT MAX(\"idPagamento\") FROM \"Pagamento\";";

       try{
           ResultSet st = connection.prepareStatement(sql).executeQuery();
           if(st.next())
               return  st.getInt("idPagamento");
           return -1;
       }
       catch (SQLException e){
           throw new RuntimeException(e);
       }
    }
}
