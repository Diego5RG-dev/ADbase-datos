import java.sql.*;
import  ADconnector.Connector;



public class CRUD {

    public static void insertarAnime(Anime anime) {
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



    public static void LeerAnimeFiltrado(String nome) {
        String sqlRead = "SELECT * FROM anime where nome = ?";

        try (Connection conn = Connector.conexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlRead)) {
            pstmt.setString(1, nome);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Anime anime = new Anime();
                    anime.setNome(rs.getString("nome"));
                    anime.setDescripcion(rs.getString("descripcion"));
                    anime.setData(rs.getDate("data"));
                    anime.setPuntuacion(rs.getInt("puntuacion"));
                    System.out.println(anime);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al leer registros: " + e.getMessage());
        }
    }

    public static void EliminarAnime(Anime anime){
        String sqlDelete = "DELETE FROM anime WHERE nome = ?";
        try (Connection conn = Connector.conexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {

            pstmt.setString(1, anime.getNome());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("-> Registro '" + anime.getNome() + "' eliminado correctamente.");
            } else {
                System.out.println("-> No se encontró el registro con nombre: " + anime.getNome());
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el registro: " + e.getMessage());
        }
    }
    public static void UpdateAnime(Anime anime, String nombreAntiguo){
        String sqlUpdate = "UPDATE anime SET nome = ?, descripcion = ?, data = ?, puntuacion = ? WHERE nome = ?";

        try (Connection conn = Connector.conexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

            pstmt.setString(1, anime.getNome());
            pstmt.setString(2, anime.getDescripcion());
            pstmt.setDate(3, anime.getData());
            pstmt.setInt(4, anime.getPuntuacion());
            pstmt.setString(5, nombreAntiguo);


            int rowsAffected = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar el registro: " + e.getMessage());
        }
    }

    public static  void leerTodosAnimes(){
        String sqlReadAll = "SELECT * FROM anime";
        try (Connection conn = Connector.conexion();
             PreparedStatement pstmt = conn.prepareStatement(sqlReadAll);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Anime anime = new Anime(
                        rs.getString("nome"),
                        rs.getString("descripcion"),
                        rs.getDate("data"),
                        rs.getInt("puntuacion")
                );
                System.out.println(anime);
            }
        } catch (SQLException e) {
            System.err.println("Error al leer todos los registros: " + e.getMessage());
        }
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
