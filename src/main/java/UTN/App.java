package UTN;

import UTN.Database.Queries;
import UTN.Models.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparing;

public class App
{
    public static void main( String[] args ) //DNI IMPAR
    {
        Humano dueno = new VikingoEspartano("Ragnar Leonidas", 40,79,15, 15);

        List<Humano> vikingos = new LinkedList<> (Arrays.<Humano>asList( //force Humano list
                new Vikingo("Asmund Hjorleifsson", 20, 72, 8),
                new Vikingo("Hjort Leiknirsson", 21, 62, 15),
                new Vikingo("Asvard Solvisson", 29, 70, 12),
                new Vikingo("Hildiglum Slodesson", 27, 74, 11),
                new Vikingo("Sighadd Bjalfisson", 24, 61, 3),
                new Vikingo("Ljot Skapsson", 31, 84, 14),
                new Vikingo("Boe Throstsson", 28, 83, 13),
                new Vikingo("Sigewulf Thorleiksson", 32, 72, 5),
                new Vikingo("Sigeric Skurfasson", 19, 82, 7),
                new Vikingo("Thorleik Jokulsson", 29, 88, 9)
        ));

        List<Humano> espartanos = new LinkedList<> (Arrays.<Humano>asList( //force Humano list
                new Espartano("Iasonas Giannopoulos", 21, 80, 7),
                new Espartano("Haris Xenakis", 27, 73, 2),
                new Espartano("Christodoulos Savas", 29, 78, 9),
                new Espartano("Panikos Zervas", 30, 90, 3),
                new Espartano("Vasso Garis", 20, 67, 10),
                new Espartano("Isidoros Lekas", 25, 76, 4),
                new Espartano("Fokionas Gabris", 23, 77, 15),
                new Espartano("Yiorgos Manikas", 20, 69, 8),
                new Espartano("Stathis Pateras", 19, 63, 6),
                new Espartano("Chrysanthos Athanas", 21, 79, 13)
        ));

        System.out.println("     ______                                   __        ______                              ");
        System.out.println("    /_  __/___  _________  ___  ____     ____/ /__     / ____/_______  ______________ ______");
        System.out.println("     / / / __ \\/ ___/ __ \\/ _ \\/ __ \\   / __  / _ \\   / /_  / ___/ _ \\/ ___/ ___/ __ `/ ___/");
        System.out.println("    / / / /_/ / /  / / / /  __/ /_/ /  / /_/ /  __/  / __/ / /  /  __(__  ) /__/ /_/ (__  ) ");
        System.out.println("   /_/  \\____/_/  /_/ /_/\\___/\\____/   \\__,_/\\___/  /_/   /_/   \\___/____/\\___/\\__,_/____/  ");

        System.out.println("\n+---------------------------------------------------------------------------------------------------+");
        System.out.println("|                                         Equipo Vikingos                                           |");
        System.out.println("+---------------------------------------------------------------------------------------------------+");
        vikingos.sort(comparing(Humano::getPeso));
        //vikingos.forEach(System.out::println); //print without box formating
        vikingos.forEach(o->System.out.format("| %s %"+(97 - o.toString().length())+"s|%n", o, "")); //%(number)s puts spaces in between, works in format, here we are getting the total lenght of the table and subtracting the legnth of the string, after that the "|", and %n to jump a line
        System.out.println("+---------------------------------------------------------------------------------------------------+\n");

        System.out.println("+---------------------------------------------------------------------------------------------------+");
        System.out.println("|                                        Equipo Espartanos                                          |");
        System.out.println("+---------------------------------------------------------------------------------------------------+");
        espartanos.sort(comparing(Humano::getPeso));
        espartanos.forEach(o->System.out.format("| %s %"+(97 - o.toString().length())+"s|%n", o,""));
        System.out.println("+---------------------------------------------------------------------------------------------------+\n");

        //Begin Torunament - Returns winner
        Humano ganador = Torneo(vikingos, espartanos);

        if(!Objects.isNull(ganador)){
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                      GANADOR FINAL DEL TORNEO                                       ║");
            System.out.println("╟ ────────────────────────────────────────────────────────────────────────────────────────────────────╢");
            System.out.format("║ %s %"+(99 - ganador.toString().length())+"s║%n", ganador, "");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════╝");

            //Store winner and get winners list
            try {
                Queries.setGanador(ganador);
            } catch (NullPointerException e) {
                System.out.println("Error el ganador no puede ser nulo");
            }
            historialDeGanadores();

            //Bout with Tavern Owner
            //Doing ASCII table by puting spaces in repated caracters for lines, then replacing that space with corresponding ascii character
            System.out.println(String.format("\n╔%125s╗","").replace(" ","═"));
            System.out.println(String.format("║%51s"+"Enfrentamiento Bonus"+"%54s║","",""));
            System.out.println(String.format("╟%125s╢","").replace(" ","─"));
            System.out.format("║ %s %"+(123 - dueno.toString().length())+"s║%n", dueno, ""); //Present owner
            System.out.println(String.format("║%60s"+"VS"+"%63s║","",""));
            System.out.format("║ %s %"+(123 - ganador.toString().length())+"s║%n", ganador, ""); //Present previous winner
            System.out.println(String.format("╟%125s╢","").replace(" ","═"));
            System.out.println(String.format("║%53s"+"Ganador Bonus"+"%59s║","",""));
            System.out.println(String.format("╟%125s╢","").replace(" ","─"));

            ganador = Enfrentamiento(dueno,ganador); //call bout

            System.out.format("║ %s %"+(123 - ganador.toString().length())+"s║%n", ganador, ""); //Show winner
            System.out.println(String.format("╚%125s╝","").replace(" ","═"));
        }
    }

    public static void historialDeGanadores(){
        List<Ganador> ganadores = Queries.getGanadores();
        System.out.println("\n+------------------------------------------------------------------------+");
        System.out.println("|                        HISTORIAL DE GANADORES                          |");
        System.out.println("+------------------------------------------------------------------------+");
        ganadores.forEach(o->System.out.format("| %s %"+(70 - o.toString().length())+"s|%n", o, ""));
        System.out.println("+------------------------------------------------------------------------+");
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

                //Individual bout
                ganador = Enfrentamiento(v,e);

                System.out.println("***Ganador enfrentamiento " + count + ": " + ganador.getClass().getSimpleName() + ", " +
                        ganador.getNombre() + ", Cantidad bebido: " + ganador.getBebidaEnCurpo() + "***");

                if(ganador instanceof Espartano) //Delete loser, ie not winner
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

        //Drinking bouts until one participant can not longer go
        while (liquidoParticipante1 <= 1000 && liquidoParticipante2 <= 1000) {

            liquidoParticipante1 += participante1.Beber();
            liquidoParticipante1 += participante1.Orinar();

            liquidoParticipante2 += participante2.Beber();
            liquidoParticipante2 += participante2.Orinar();

            //Deprecated method
            /*liquidoParticipante1 += Drink(participante1);
            liquidoParticipante2 += Drink(participante2);
            */

            //For debugging
            /*System.out.println("Participante1: " + liquidoParticipante1);
            System.out.println("Participante2: " + liquidoParticipante2);
            */
        }

        //Store amount drank
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

    /*
    * Discarded method, not needed to cast if the substraction of the attribute is done in the class.
    public static int Drink(Humano participante){
        int liquido = 0;

        //If not for individual properties of the classes, the implementetion of the strategy would not need the IFs, and
        //would be 3 lines only
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
    }*/

}
