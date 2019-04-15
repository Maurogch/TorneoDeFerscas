package UTN;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparing;

public class App
{
    public static void main( String[] args )
    {
        List<Humano> vikingos = new LinkedList<> (Arrays.<Humano>asList( //force Humano list
                new Vikingo("Asmund Hjorleifsson", 20, 72, new OrinarVikingoImp(), new BeberVikingoImp(), 8),
                new Vikingo("Hjort Leiknirsson", 21, 62, new OrinarVikingoImp(), new BeberVikingoImp(), 15),
                new Vikingo("Asvard Solvisson", 29, 70, new OrinarVikingoImp(), new BeberVikingoImp(), 12),
                new Vikingo("Hildiglum Slodesson", 27, 74, new OrinarVikingoImp(), new BeberVikingoImp(), 11),
                new Vikingo("Sighadd Bjalfisson", 24, 61, new OrinarVikingoImp(), new BeberVikingoImp(), 3),
                new Vikingo("Ljot Skapsson", 31, 84, new OrinarVikingoImp(), new BeberVikingoImp(), 14),
                new Vikingo("Boe Throstsson", 28, 83, new OrinarVikingoImp(), new BeberVikingoImp(), 13),
                new Vikingo("Sigewulf Thorleiksson", 32, 72, new OrinarVikingoImp(), new BeberVikingoImp(), 5),
                new Vikingo("Sigeric Skurfasson", 19, 82, new OrinarVikingoImp(), new BeberVikingoImp(), 7),
                new Vikingo("Thorleik Jokulsson", 29, 88, new OrinarVikingoImp(), new BeberVikingoImp(), 9)
        ));

        List<Humano> espartanos = new LinkedList<> (Arrays.<Humano>asList( //force Humano list
                new Espartano("Iasonas Giannopoulos", 21, 80, new OrinarEspartanoImp(), new BeberEspartanoImp(), 7),
                new Espartano("Haris Xenakis", 27, 73, new OrinarEspartanoImp(), new BeberEspartanoImp(), 2),
                new Espartano("Christodoulos Savas", 29, 78, new OrinarEspartanoImp(), new BeberEspartanoImp(), 9),
                new Espartano("Panikos Zervas", 30, 90, new OrinarEspartanoImp(), new BeberEspartanoImp(), 3),
                new Espartano("Vasso Garis", 20, 67, new OrinarEspartanoImp(), new BeberEspartanoImp(), 10),
                new Espartano("Isidoros Lekas", 25, 76, new OrinarEspartanoImp(), new BeberEspartanoImp(), 4),
                new Espartano("Fokionas Gabris", 23, 77, new OrinarEspartanoImp(), new BeberEspartanoImp(), 15),
                new Espartano("Yiorgos Manikas", 20, 69, new OrinarEspartanoImp(), new BeberEspartanoImp(), 8),
                new Espartano("Stathis Pateras", 19, 63, new OrinarEspartanoImp(), new BeberEspartanoImp(), 6),
                new Espartano("Chrysanthos Athanas", 21, 79, new OrinarEspartanoImp(), new BeberEspartanoImp(), 13)
        ));

        System.out.println("---------------------------Equipo Vikingos----------------------------");
        vikingos.sort(comparing(Humano::getPeso));
        vikingos.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------\n");

        System.out.println("---------------------------Equipo Espartanos---------------------------");
        espartanos.sort(comparing(Humano::getPeso));
        espartanos.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------\n");

        Humano ganador = Torneo(vikingos, espartanos);

        if(!Objects.isNull(ganador)){
            System.out.println("==========================================================================");
            System.out.println("                         GANADOR FINAL DEL TORNEO");
            System.out.println("==========================================================================");
            System.out.println(ganador.toString());
        }
    }

    public static Humano Torneo(List<Humano> vikingos, List<Humano> espartanos){
        Humano ganador = null;

        try {
            int count = 1;


            while (vikingos.size() > 0 && espartanos.size() > 0) {

                Humano v = (Humano)((LinkedList)vikingos).getFirst();
                Humano e = (Humano)((LinkedList)espartanos).getFirst();

                System.out.println("-Enfrentamiento nº" + count);
                System.out.println(v);
                System.out.println("                          VS");
                System.out.println(e);

                ganador = Enfrentamiento(v,e);

                System.out.println("***Ganador enfrentamiento " + count + ": " + ganador.getClass().getSimpleName() + ", " +
                        ganador.getNombre() + ", Cantidad bebido: " + ganador.getBebidaEnCurpo() + "***");

                if(ganador instanceof Vikingo)
                    ((LinkedList<Humano>) vikingos).removeFirst();
                else
                    ((LinkedList<Humano>) espartanos).removeFirst();

                System.out.println("Cantidad de participantes en el equipo vikingo: " + vikingos.size());
                System.out.println("Cantidad de participantes en el equipo espartanto: " + espartanos.size() + "\n");

                count++;
            }
        } catch (NotVikingOrSpartanException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return ganador;
    }

    public static Humano Enfrentamiento(Humano v, Humano e) throws NotVikingOrSpartanException {
        if(!(v instanceof Vikingo)){
            throw new NotVikingOrSpartanException("Primera instancia debe ser del tipo Vikingo");
        }

        if(!(e instanceof Espartano)){
            throw new NotVikingOrSpartanException("Primera instancia debe ser del tipo Espartano");
        }

        int liquidoVikingo = 0;
        int liquidoEspartano = 0;

        int liquidoParticipante1 = 0;
        int liquidoParticipante2 = 0;

        //Drinking bouts untill one can not longer go
        while (liquidoVikingo <= 1000 && liquidoEspartano <= 1000) {
            liquidoVikingo += v.Beber() - ((Vikingo) v).getBebedorProfecional();
            if(liquidoVikingo < 0) liquidoVikingo = 0; //no negative drinking values
            liquidoVikingo += v.Orinar();

            liquidoEspartano += e.Beber();
            liquidoEspartano += e.Orinar() - ((Espartano) e).getToleranciaExtra();
            if(liquidoEspartano < 0) liquidoEspartano = 0;

            if(v instanceof Vikingo){

            }


            System.out.println("Vikingo: " + liquidoVikingo);
            System.out.println("Espartano: " + liquidoEspartano);

        }

        //Drinking bouts untill one can not longer go
        /*while (liquidoVikingo <= 1000 && liquidoEspartano <= 1000) {
            liquidoVikingo += v.Beber() - ((Vikingo) v).getToleranciaExtra();
            if(liquidoVikingo < 0) liquidoVikingo = 0; //no negative drinking values
            liquidoVikingo += v.Orinar();

            liquidoEspartano += e.Beber();
            liquidoEspartano += e.Orinar() - ((Espartano) e).getBebedorProfecional();
            if(liquidoEspartano < 0) liquidoEspartano = 0;

            /*For debugging battle
            System.out.println("Vikingo: " + liquidoVikingo);
            System.out.println("Espartano: " + liquidoEspartano);

        }*/

        v.setBebidaEnCurpo(liquidoVikingo);
        e.setBebidaEnCurpo(liquidoEspartano);

        //Return winner
        if(liquidoVikingo < 1000) {
            return v;
        }
        else if (liquidoEspartano < 1000){
            return e;
        }else{ //In case of draw
            if(liquidoVikingo > liquidoEspartano)
                return v;
            else
                return e;
        }
    }
}
