package implementazionePostgresDAO;

import dao.StaffDAO;
import model.Staff;

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
    public void recuperaStaff(ArrayList<Staff> membriDelloStaff) {
        String sql = "SELECT * FROM \"Staff\"";
        ResultSet st;
        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                Staff nuovoMembro = new Staff(st.getInt("matricola"),st.getString("nome"),st.getString("cognome"),st.getDouble("stipendio"));
                membriDelloStaff.add(nuovoMembro);
            }
            st.close();
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
