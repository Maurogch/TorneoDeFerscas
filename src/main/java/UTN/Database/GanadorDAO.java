package UTN.Database;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import UTN.Models.Ganador;
import UTN.Models.Humano;
import org.apache.commons.dbutils.DbUtils;


public class GanadorDAO {
    private static final String TABLE = "Ganadores";
    private Statement stmt = null;
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pStmt = null;

    public List<Ganador> getGanadores(){

        List<Ganador> ganadores = new LinkedList<>();

        try {
            conn = JDBCConnection.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT idGanador, nombreGanador, bebidaEnCuerpo FROM " + TABLE;
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("idGanador");
                String nombre = rs.getString("nombreGanador");
                int liquido = rs.getInt("bebidaEnCuerpo");

                ganadores.add(new Ganador(id, nombre, liquido));
            }
        } catch (SQLException e) {
            //Handle errors for JDBCConnection
            System.out.println("Error connecting to database");
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(conn);
        }

        return ganadores;
    }

    public int setGanador(Humano ganador) throws NullPointerException{
        int affectedRows = 0;

        if(Objects.isNull(ganador)) throw new NullPointerException();

        try {
            conn = JDBCConnection.getInstance().getConnection();
            String sql;
            sql = "INSERT INTO " + TABLE + " (nombreGanador, bebidaEnCuerpo)" +
                    "VALUES (?, ?)";
            pStmt = conn.prepareStatement(sql);

            pStmt.setString(1,ganador.getNombre());
            pStmt.setInt(2,ganador.getBebidaEnCurpo());

            affectedRows = pStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(pStmt);
            DbUtils.closeQuietly(conn);
        }

        return affectedRows;
    }
}
