package UTN;

public class VikingoEspartano extends Humano {
    private Integer bebedorProfecional;
    private Integer toleranciaExtra;

    public VikingoEspartano(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber, Integer bebedorProfecional, Integer toleranciaExtra) {
        super(nombre, edad, peso, orinar, beber);
        this.bebedorProfecional = bebedorProfecional;
        this.toleranciaExtra = toleranciaExtra;
    }

    public Integer getBebedorProfecional() {
        return bebedorProfecional;
    }

    public void setBebedorProfecional(Integer bebedorProfecional) {
        this.bebedorProfecional = bebedorProfecional;
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

    public void setToleranciaExtra(Integer toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    @Override
    public String toString() {
        return "VikingoEspartano{" +
                super.toString() + ", " +
                "bebedorProfecional=" + bebedorProfecional +
                ", toleranciaExtra=" + toleranciaExtra +
                '}';
    }
}
