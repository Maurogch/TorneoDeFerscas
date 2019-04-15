package UTN;

import UTN.Behaviours.BeberEspartanoImp;
import UTN.Behaviours.BeberVikingoImp;
import UTN.Behaviours.OrinarEspartanoImp;
import UTN.Behaviours.OrinarVikingoImp;
import UTN.Models.Espartano;
import UTN.Models.Humano;
import UTN.Models.Vikingo;
import UTN.Models.VikingoEspartano;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparing;

public class App
{
    public static void main( String[] args )
    {
        Humano dueno = new VikingoEspartano("Ragnar Leonidas", 40,79, new OrinarEspartanoImp(), new BeberVikingoImp(),15, 15);

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

            System.out.println("\nEnfrentamiento Bonus: ");
            System.out.println(dueno);
            System.out.println("VS");
            System.out.println(ganador);

            ganador = Enfrentamiento(dueno,ganador);

            System.out.println("***Ganador enfrentamiento bonus: " + ganador.getClass().getSimpleName() + ", " +
                    ganador.getNombre() + ", Cantidad bebido: " + ganador.getBebidaEnCurpo() + "***");
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
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return ganador;
    }

    public static Humano Enfrentamiento(Humano participante1, Humano participante2){
        int liquidoParticipante1 = 0;
        int liquidoParticipante2 = 0;

        //Drinking bouts until one can not longer go
        while (liquidoParticipante1 <= 1000 && liquidoParticipante2 <= 1000) {
            liquidoParticipante1 += Drink(participante1);
            liquidoParticipante2 += Drink(participante2);

            //For debugging
            /*System.out.println("Participante1: " + liquidoParticipante1);
            System.out.println("Participante2: " + liquidoParticipante2);
            */
        }

        participante1.setBebidaEnCurpo(liquidoParticipante1);
        participante2.setBebidaEnCurpo(liquidoParticipante2);

        //Return winner
        if(liquidoParticipante1 < 1000) {
            return participante1;
        }
        else if (liquidoParticipante2 < 1000){
            return participante2;
        }else{ //In case of draw
            if(liquidoParticipante1 > liquidoParticipante2)
                return participante1;
            else
                return participante2;
        }
    }

    public static int Drink(Humano participante){
        int liquido = 0;

        if(participante instanceof Vikingo){
            liquido += participante.Beber() - ((Vikingo) participante).getBebedorProfecional();
        }else if (participante instanceof VikingoEspartano){
            liquido += participante.Beber() - ((VikingoEspartano) participante).getBebedorProfecional();
        }else{
            liquido += participante.Beber();
        }

        if(liquido < 0) liquido = 0; //no negative drinking values

        if(participante instanceof Espartano){
            liquido += participante.Orinar() - ((Espartano) participante).getToleranciaExtra();
        }else if (participante instanceof VikingoEspartano){
            liquido += participante.Orinar() - ((VikingoEspartano) participante).getToleranciaExtra();
        }else {
            liquido += participante.Orinar();
        }

        if(liquido < 0) liquido = 0;

        return liquido;
    }
}
