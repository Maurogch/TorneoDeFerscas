package UTN.Models;

import UTN.Interfaces.Beber;
import UTN.Interfaces.Orinar;

public class Vikingo extends Humano {
    private Integer bebedorProfecional;

    public Vikingo(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber, Integer bebedorProfecional) {
        super(nombre, edad, peso, orinar, beber);
        this.bebedorProfecional = bebedorProfecional;
    }

    public Integer getBebedorProfecional() {
        return bebedorProfecional;
    }

    public void setBebedorProfecional(Integer bebedorProfecional) {
        this.bebedorProfecional = bebedorProfecional;
    }

    @Override
    public String toString() {
        return "Espartano{" +
                super.toString() + ", " +
                "bebedorProfecional=" + bebedorProfecional +
                '}';
    }
}
