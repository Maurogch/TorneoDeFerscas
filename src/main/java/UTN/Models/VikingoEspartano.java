package UTN.Models;

import UTN.Behaviours.BeberVikingoImp;
import UTN.Behaviours.OrinarEspartanoImp;

public class VikingoEspartano extends Humano {
    private Integer bebedorProfecional;
    private Integer toleranciaExtra;

    public VikingoEspartano(String nombre, Integer edad, Integer peso, Integer bebedorProfecional, Integer toleranciaExtra) {
        super(nombre, edad, peso, new OrinarEspartanoImp(), new BeberVikingoImp());
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
    public Integer Orinar() {
        int res =super.Orinar() - toleranciaExtra;
        if(res < 0) res = 0;
        return res;
    }

    @Override
    public Integer Beber() {
        int res =super.Orinar() - bebedorProfecional;
        if(res < 0) res = 0;
        return res;
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
