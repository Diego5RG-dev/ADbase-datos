import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class anime {
private String nome;
private String descripcion;
private String data;
private String puntuacion;

public anime(String nome, String descripcion, String data, String puntuacion) {
    this.nome = nome;
    this.descripcion = descripcion;
    this.data = data;
    this.puntuacion = puntuacion;
}

    public String dateToString(Date dataD) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(dataD);
    }
    public Date stringToDate(String dataStr) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date dataUtil = formato.parse(dataStr);
            return new Date(dataUltil.getTime());
        } catch (ParseException e) {
            System.out.println("Error al convertir la cadena a fecha: " + e.getMessage());
            return null;
        }
    }

}


