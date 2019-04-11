package UTN;

public class Espartano extends Humano{
    private Integer bebedorProfecional;

    public Espartano(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber, Integer bebedorProfecional) {
        super(nombre, edad, peso, orinar, beber);
        this.bebedorProfecional = bebedorProfecional;
    }

    public Integer getBebedorProfecional() {
        return bebedorProfecional;
    }

    public void setBebedorProfecional(Integer bebedorProfecional) {
        this.bebedorProfecional = bebedorProfecional;
    }
}
