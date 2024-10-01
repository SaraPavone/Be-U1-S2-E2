import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class esercizio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> parole = new HashSet<>();
        Set<String> duplicate = new HashSet<>();

        System.out.println("Inserisci il numero di parole: ");
        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Parola " + (i + 1) + ": ");
            String parola = scan.nextLine();
            if (!parole.add(parola)) {
                duplicate.add(parola);
            }
        }
        System.out.println("Parole duplicate: " + duplicate);
        System.out.println("Numero parole distinte: " + parole.size());
        System.out.println("Parole distinte: " + parole);

    }
}
