package OperacionesCRUD;
import java.sql.*;
import  ADconnector.Connector;

public class CRUD {



    public static void executeSQL (String sqlExecutable){
        try (Connection conn = Connector.conexion();
             PreparedStatement toRead = conn.prepareStatement(sqlExecutable);
             ResultSet resultSet = toRead.executeQuery();
        ){
            while (resultSet.next()) {
                System.out.println("proba: " + resultSet.getString("proba"));
            }
        } catch (SQLException e) {
            System.out.println("Error leyendo" + e.getMessage());
        }
    }

}
