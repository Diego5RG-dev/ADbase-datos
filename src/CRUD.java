import java.sql.*;
import  ADconnector.Connector;



public class CRUD {

    public void insertarAnime(Anime anime) {
        String sql = "INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES (?, ?, ?, ?)";

        try (Connection conn = Connector.conexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, anime.getNome());
            pstmt.setString(2, anime.getDescripcion());
            pstmt.setDate(3, anime.getData());
            pstmt.setInt(4, anime.getPuntuacion());

            pstmt.executeUpdate();
            System.out.println("-> Registro '" + anime.getNome() + "' insertado correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al insertar el registro: " + e.getMessage());
        }
    }

    public void LeerDatosAnime() {
        String sqlRead = "SELECT * FROM anime";
        executeSQL(sqlRead);
    }

    public Anime LeerAnimeFiltrado(String nome){
        Anime anime = null;
        String sqlRead = "SELECT * FROM anime WHERE nome = ?";
        try (Connection conn = Connector.conexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlRead)) {

            pstmt.setString(1, nome);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    anime = new Anime(
                            rs.getString("nome"),
                            rs.getString("descripcion"),
                            rs.getDate("data"),
                            rs.getInt("puntuacion")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al leer el registro filtrado: " + e.getMessage());
        }
        return anime;
    }

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
