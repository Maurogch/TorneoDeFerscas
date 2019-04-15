package UTN.Models;

import UTN.Behaviours.BeberEspartanoImp;
import UTN.Behaviours.OrinarEspartanoImp;

public class Espartano extends Humano{
    private Integer toleranciaExtra;

    public Espartano(String nombre, Integer edad, Integer peso, Integer toleranciaExtra) {
        super(nombre, edad, peso, new OrinarEspartanoImp(), new BeberEspartanoImp());
        this.toleranciaExtra = toleranciaExtra;
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
    public String toString() {
        return "Espartano{" +
                super.toString() + ", " +
                "toleranciaExtra=" + toleranciaExtra +
                '}';
    }
}
