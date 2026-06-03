package implementazionePostgresDAO;

import dao.ClienteDAO;
import model.Cliente;
import model.ClienteVIP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class ClienteImplementazionePostgresDAO implements ClienteDAO {
    private Connection connection;

    public ClienteImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void recuperaClienti(ArrayList<String> email, ArrayList<String> nome, ArrayList<String> cognome, ArrayList<String> password, ArrayList<String> tipo, ArrayList<Double> percentualeSconto) {
        String sql = "SELECT * FROM \"Cliente\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                email.add(st.getString("email"));
                nome.add(st.getString("nome"));
                cognome.add(st.getString("cognome"));
                password.add(st.getString("password"));
                tipo.add(st.getString("tipo"));
                percentualeSconto.add(st.getDouble("percentualeSconto"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
