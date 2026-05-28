package implementazionePostgresDAO;

import dao.ClienteDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteImplementazionePostgresDAO implements ClienteDAO {
    private Connection connection;

    @Override
    public void recuperaClienti(ArrayList<String> email, ArrayList<String> password, ArrayList<String> nome, ArrayList<String> cognome) {
        String sql = "SELECT * FROM \"Cliente\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                email.add(st.getString("email"));
                password.add(st.getString("password"));
                nome.add(st.getString("nome"));
                cognome.add(st.getString("cognome"));
            }
            st.close();
            connection.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
