import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class esercizio3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Creiamo una rubrica (lista di contatti) prima dello switch per renderla accessibile a tutti i case
        ArrayList<HashMap<String, Integer>> rubrica = new ArrayList<>();

        // Mostriamo il menu all'utente
        int scelta;
        do {
            System.out.println("Benvenuto nel sistema di gestione di una rubrica telefonica!");
            System.out.println("Cosa vuoi fare?: ");
            System.out.println("1. Creare un contatto");
            System.out.println("2. Eliminare un contatto");
            System.out.println("3. Cercare un contatto per numero");
            System.out.println("4. Cercare un contatto per nome");
            System.out.println("5. Visualizzare tutti i contatti");
            System.out.println("6. Esci dal sistema");
            scelta = scan.nextInt();
            scan.nextLine();  // Consuma il newline

            switch (scelta) {
                case 1:
                    String risposta;
                    do {
                        // Richiedi nome e numero per creare un contatto
                        System.out.println("Inserisci il nome del contatto: ");
                        String nome = scan.nextLine();
                        System.out.println("Inserisci il numero del contatto: ");
                        Integer numero = Integer.parseInt(scan.nextLine());

                        // Crea il contatto e aggiungilo alla rubrica
                        HashMap<String, Integer> contatto = creaContatto(nome, numero);
                        rubrica.add(contatto);

                        System.out.println("Il contatto inserito è: " + contatto);

                        // Chiedi all'utente se vuole aggiungere un altro contatto
                        System.out.println("Vuoi inserire un altro contatto? (s/n)");
                        risposta = scan.nextLine();

                    } while (risposta.equalsIgnoreCase("s"));
                    break;

                case 2:
                    // Eliminazione contatto
                    System.out.println("Inserisci il nome del contatto da eliminare: ");
                    String nomeDaEliminare = scan.nextLine();
                    eliminaContatto(rubrica, nomeDaEliminare);
                    break;

                case 3:
                    // Ricerca contatto per numero
                    System.out.println("Inserisci il numero del contatto da cercare: ");
                    Integer numeroDaCercare = Integer.parseInt(scan.nextLine());
                    ricercaPerNum(rubrica, numeroDaCercare);
                    break;

                case 4:
                    // Ricerca contatto per nome
                    System.out.println("Inserisci il nome del contatto da cercare: ");
                    String nomeDaCercare = scan.nextLine();
                    ricercaPerNome(rubrica, nomeDaCercare);
                    break;

                case 5:
                    // Visualizza tutti i contatti
                    // Mostra il numero di contatti nella rubrica
                    System.out.println("Il numero attuale di contatti in rubrica è: " + rubrica.size());

                    // Stampa tutti i contatti nella rubrica
                    for (HashMap<String, Integer> contatto : rubrica) {
                        System.out.println(contatto);
                    }
                    break;


                case 6:
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println("Scelta non valida, riprova.");
                    break;
            }
        } while (scelta != 5);

        scan.close();
    }

    // Funzione per creare un contatto
    public static HashMap<String, Integer> creaContatto(String nome, Integer numero) {
        HashMap<String, Integer> contatto = new HashMap<>();
        contatto.put(nome, numero);
        return contatto;
    }

    // Funzione per eliminare un contatto
    public static void eliminaContatto(ArrayList<HashMap<String, Integer>> rubrica, String nome) {
        // Cerca e rimuove il contatto con il nome specificato
        boolean trovato = false;
        for (HashMap<String, Integer> contatto : rubrica) {
            if (contatto.containsKey(nome)) {
                rubrica.remove(contatto);
                System.out.println("Contatto " + nome + " rimosso con successo.");
                trovato = true;
                break; // Esci dal ciclo dopo aver rimosso il contatto
            }
        }
        if (!trovato) {
            System.out.println("Contatto " + nome + " non trovato.");
        }
    }

    // Funzione per cercare un contatto per nome
    public static void ricercaPerNome(ArrayList<HashMap<String, Integer>> rubrica, String nome) {
        boolean trovato = false;
        // Cerca il contatto con il nome specificato
        for (HashMap<String, Integer> contatto : rubrica) {
            if (contatto.containsKey(nome)) {
                System.out.println("Contatto trovato: " + contatto);
                trovato = true;
                break; // Esci dal ciclo dopo aver trovato il contatto
            }
        }
        if (!trovato) {
            System.out.println("Contatto con nome " + nome + " non trovato.");
        }
    }

    // Funzione per cercare un contatto per numero
    public static void ricercaPerNum(ArrayList<HashMap<String, Integer>> rubrica, Integer num) {
        boolean trovato = false;
        // Cerca il contatto con il numero specificato
        for (HashMap<String, Integer> contatto : rubrica) {
            if (contatto.containsValue(num)) {
                System.out.println("Contatto trovato: " + contatto);
                trovato = true;
                break; // Esci dal ciclo dopo aver trovato il contatto
            }
        }
        if (!trovato) {
            System.out.println("Contatto con numero " + num + " non trovato.");
        }
    }
}


