package UTN.Models;

public class Ganador {
    Integer id;
    String nombre;
    Integer bebidaEnCuerpo;

    public Ganador(Integer id, String nombre, Integer bebidaEnCuerpo) {
        this.id = id;
        this.nombre = nombre;
        this.bebidaEnCuerpo = bebidaEnCuerpo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getBebidaEnCuerpo() {
        return bebidaEnCuerpo;
    }

    public void setBebidaEnCuerpo(Integer bebidaEnCuerpo) {
        this.bebidaEnCuerpo = bebidaEnCuerpo;
    }

    @Override
    public String toString() {
        return "Ganador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", bebidaEnCuerpo=" + bebidaEnCuerpo +
                '}';
    }
}
