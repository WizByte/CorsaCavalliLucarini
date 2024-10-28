import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GaraCavalli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Scanner per leggere input dall'utente

        System.out.print("Inserire la lunghezza del percorso in metri: ");
        int percorsoTotale = scanner.nextInt();
        scanner.nextLine();

        List<Cavallo> cavalli = new ArrayList<>(); //Crea una lista per memorizzare i cavalli
        System.out.print("Inserire il numero di cavalli in gara: ");
        int numeroCavalli = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numeroCavalli; i++) {
            System.out.print("Inserire il nome del cavallo " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            cavalli.add(new Cavallo(nome, percorsoTotale));
        }

        System.out.println("\nLa gara inizia!\n");

        for (Cavallo cavallo : cavalli) { //Avvia i thread per ciascun cavallo in modo che partano contemporaneamente
            cavallo.start();
        }

        for (Cavallo cavallo : cavalli) { //Aspetta che tutti i cavalli completino la gara prima di terminare il programma
            try {
                cavallo.join(); //Attende il completamento del thread "cavallo"
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nGara terminata!");
        scanner.close();
    }
}