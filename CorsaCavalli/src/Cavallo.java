import java.util.Random;

class Cavallo extends Thread {
    private final String nome;
    private final int percorsoTotale;
    private int metriPercorsi = 0;
    private final Random random = new Random();

    public Cavallo(String nome, int percorsoTotale) {
        this.nome = nome;
        this.percorsoTotale = percorsoTotale;
    }

    @Override
    public void run() { //Metodo run() eseguito quando il thread viene avviato che simula l’avanzamento del cavallo
        while (metriPercorsi < percorsoTotale) {
            int passo = random.nextInt(10) + 1; //Genera un numero casuale tra 1 e 10
            metriPercorsi += passo;

            if (metriPercorsi > percorsoTotale) {//Se i metri percorsi superano il percorso totale
                metriPercorsi = percorsoTotale;  //vengono impostati al valore del percorso per non andare oltre
            }

            System.out.println("[" + nome + "] ha percorso " + metriPercorsi + " metri");

            try {
                Thread.sleep(500); //Pausa di 500 millisecondi (0.5 secondi)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("[" + nome + "] ha tagliato il traguardo!");
    }
}