package implementazionePostgresDAO;

import dao.StaffDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffImplementazionePostgresDAO implements StaffDAO {
    private Connection connection;

    public StaffImplementazionePostgresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void recuperaStaff(ArrayList<Integer> matricola, ArrayList<String> nome, ArrayList<String> cognome, ArrayList<Double> stipendio) {
        String sql = "SELECT * FROM \"Staff\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                matricola.add(st.getInt("matricola"));
                nome.add(st.getString("nome"));
                cognome.add(st.getString("cognome"));
                stipendio.add(st.getDouble("stipendio"));
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
