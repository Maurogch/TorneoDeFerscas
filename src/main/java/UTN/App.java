package UTN;

import java.util.concurrent.ThreadLocalRandom;

public class App
{
    public static void main( String[] args )
    {
        Humano v = new Vikingo("Asmund Hjorleifsson", 20, 72, new OrinarVikingoImp(), new BeberVikingoImp(), 90);
        Humano e = new Espartano("Iasonas Giannopoulos", 21, 80, new OrinarEspartanoImp(), new BeberEspartanoImp(), 80);

        try {
            Humano ganador = Enfrentamiento(v,e);
            System.out.println("Ganador:" + ganador.getNombre());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*Very Proof of concert, will change, osea no corrijan esto

     */
    public static Humano Enfrentamiento(Humano v, Humano e) throws Exception {
        if(!(v instanceof Vikingo)){
            throw new Exception("Primera instancia debe ser del tipo Vikingo");
        }

        if(!(e instanceof Espartano)){
            throw new Exception("Primera instancia debe ser del tipo Espartano");
        }

        int vikingo = 0;
        int espartano = 0;

        while (vikingo <= 500 && espartano <= 500) {
            vikingo += v.getBeber().Beber() - ((Vikingo) v).getToleranciaExtra();
            vikingo += v.getOrinar().Orinar();

            espartano += e.getBeber().Beber();
            espartano += e.getOrinar().Orinar() - ((Espartano) e).getBebedorProfecional();

            System.out.println("Vikingo: " + vikingo);
            System.out.println("Espartano: " + espartano);
        }

        if(vikingo <= 1000)
            return v;
        else
            return e;
    }
}
