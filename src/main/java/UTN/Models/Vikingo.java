package UTN.Models;

import UTN.Behaviours.BeberVikingoImp;
import UTN.Behaviours.OrinarVikingoImp;

public class Vikingo extends Humano {
    private Integer bebedorProfecional;

    public Vikingo(String nombre, Integer edad, Integer peso, Integer bebedorProfecional) {
        super(nombre, edad, peso, new OrinarVikingoImp(), new BeberVikingoImp());
        this.bebedorProfecional = bebedorProfecional;
    }

    public Integer getBebedorProfecional() {
        return bebedorProfecional;
    }

    public void setBebedorProfecional(Integer bebedorProfecional) {
        this.bebedorProfecional = bebedorProfecional;
    }

    @Override
    public Integer Beber() {
        int res =super.Orinar() - bebedorProfecional;
        if(res < 0) res = 0;
        return res;
    }

    @Override
    public String toString() {
        return "Vikingo{" +
                super.toString() + ", " +
                "bebedorProfecional=" + bebedorProfecional +
                '}';
    }
}
