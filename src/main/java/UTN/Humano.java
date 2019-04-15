package UTN;

public class Humano {
    private String nombre;
    private Integer edad;
    private Integer peso;
    private Orinar orinar;
    private Beber beber;
    private Integer bebidaEnCurpo;

    protected Humano(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.orinar = orinar;
        this.beber = beber;
        this.bebidaEnCurpo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getBebidaEnCurpo() {
        return bebidaEnCurpo;
    }

    public void setBebidaEnCurpo(Integer bebidaEnCurpo) {
        this.bebidaEnCurpo = bebidaEnCurpo;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", bebidaEnCurpo=" + bebidaEnCurpo;
    }

    public Integer Orinar() {
        return orinar.Orinar();
    } //return implementation method, easier to call in main

    public Integer Beber() {
        return beber.Beber();
    } //return implementation method
}
