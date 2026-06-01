package implementazionePostgresDAO;

import dao.PostoDAO;
import model.Posto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostoImplementazionePostgresDAO implements PostoDAO {
    private Connection connection;

    public PostoImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void recuperaPosti(ArrayList<Posto> posti) {
        String sql = "SELECT * FROM \"Posto\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
//                fila.add(st.getString("fila"));
//                numero.add(st.getInt("numero"));
//                codicePosto.add(st.getString("codicePosto"));
//                sala.add(st.getInt("sala"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
