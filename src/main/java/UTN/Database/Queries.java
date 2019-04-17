package UTN.Database;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import UTN.Models.Ganador;
import UTN.Models.Humano;
import org.apache.commons.dbutils.DbUtils;

public class Queries{
    private static final String TABLE = "Ganadores";

    public static List<Ganador> getGanadores(){
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
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
            //Clean-up environment, using DbUtils repository
            //closeQuietly = Close a Connection, avoid closing if null and hide any SQLExceptions that occur.
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(conn);
        }

        return ganadores;
    }

    public static int setGanador(Humano ganador) throws NullPointerException{
        Connection conn = null;
        PreparedStatement pStmt = null;
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
