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
    public void recuperaClienti(ArrayList<Cliente> elencoClienti) {
        String sql = "SELECT * FROM \"Cliente\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                if(Objects.equals(st.getString("tipo"), "VIP")){
                    ClienteVIP nuovoClienteVIP = new ClienteVIP(st.getString("email"),st.getString("nome"),st.getString("cognome"),st.getDouble("percentualeSconto"),st.getString("password"));
                    elencoClienti.add(nuovoClienteVIP);
                }
                else{
                    Cliente nuovoCliente = new Cliente(st.getString("email"),st.getString("nome"),st.getString("cognome"),st.getString("password"));
                    elencoClienti.add(nuovoCliente);
                }
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
