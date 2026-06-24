package implementazionePostgresDAO;

import dao.SalaDAO;
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

    @Override
    public void recuperaDatiStaffSAle(ArrayList<Integer> numeroMatricola, ArrayList<Integer> numeroSala) {
        String sql = "SELECT * FROM \"Gestisce\"";
        ResultSet st;

        try{
            st = connection.prepareStatement(sql).executeQuery();
            while(st.next()){
                numeroSala.add(st.getInt("numeroSala"));
                numeroMatricola.add(st.getInt("matricola"));
            }
            st.close();
            return;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
