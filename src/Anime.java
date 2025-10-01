import java.sql.Date;
import java.text.SimpleDateFormat;

public class Anime {
    private String nome;
    private String descripcion;
    private Date data;
    private int puntuacion;

    // Constructor
    public Anime(String nome, String descripcion, Date data, int puntuacion) {
        this.nome = nome;
        this.descripcion = descripcion;
        this.data = data;
        this.puntuacion = puntuacion;
    }
    public Anime() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String dateToString(Date dataD) {
        if (dataD == null) {
            return "N/A";
        }
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(dataD);
    }

    @Override
    public String toString() {
        return "Anime {" +
                "nome='" + nome + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", data=" + dateToString(data) +
                ", puntuacion=" + puntuacion +
                '}';
    }
}