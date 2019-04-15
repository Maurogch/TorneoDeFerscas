package UTN.Database;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import UTN.Models.Ganador;
import UTN.Models.Humano;

public class JDBC {
    //  JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/TorneoDeFrescas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    //  Singleton
    private static JDBC driver;

    public static JDBC getInstance() {
        if (driver==null) {
            driver = new JDBC();
        }
        return driver;
    }

    private JDBC(){
    }

    public List<Ganador> getGanadores(){
        Connection conn = null;
        Statement stmt = null;
        List<Ganador> ganadores = new LinkedList<>();

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT idGanador, nombreGanador, bebidaEnCuerpo FROM Ganadores";
            ResultSet rs = stmt.executeQuery(sql);


            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("idGanador");
                String nombre = rs.getString("nombreGanador");
                int liquido = rs.getInt("bebidaEnCuerpo");

                ganadores.add(new Ganador(id, nombre, liquido));
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            System.out.println("MySql Driver not installed");
        } catch (SQLException e) {
            //Handle errors for JDBC
            e.printStackTrace();
            System.out.println("Error connecting to database");
        }

        return ganadores;
    }

    public int setGanador(Humano ganador) {
        Connection conn = null;
        Statement stmt = null;
        int affectedRows = 0;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = String.format("INSERT INTO Ganadores (nombreGanador, bebidaEnCuerpo)" +
                                "VALUES ('%s', '%s')", ganador.getNombre(), ganador.getBebidaEnCurpo());
            affectedRows = stmt.executeUpdate(sql);

            //Clean-up environment
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            System.out.println("MySql Driver not installed");
        } catch (SQLException e) {
            //Handle errors for JDBC
            e.printStackTrace();
            System.out.println("Error connecting to database");
        }

        return affectedRows;
    }
}
