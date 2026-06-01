package implementazionePostgresDAO;

import dao.SalaDAO;
import model.Sala;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaImplementazionePostgresDAO implements SalaDAO {
    private Connection connection;

    public SalaImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void recuperaSale(ArrayList<Sala> sale) {
        String sql = "SELECT * FROM \"Sala\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                Sala nuovaSala = new Sala(st.getInt("numeroSala"),st.getInt("capienza"));
                sale.add(nuovaSala);
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
