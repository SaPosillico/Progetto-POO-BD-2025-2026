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
    public void recuperaSale(ArrayList<Integer> numeroSala, ArrayList<Integer> capienza) {
        String sql = "SELECT * FROM \"Sala\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                numeroSala.add(st.getInt("numeroSala"));
                capienza.add(st.getInt("capienza"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
