package ADconnector;
import java.sql.*;

public class Connector {
    public static Connection conexion(){
        Connection conn = null;
        try {
            String url = "jdbc:mysql://10.0.9.114:5432/anime";
            String usuario = "postgres";
            String password = "admin";
            conn = DriverManager.getConnection(url, usuario, password);
        }catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
