import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class esercizio2 {
    public static List<Integer> generaCasuale(int N) {

        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(random.nextInt(101));
        }
        Collections.sort(list);
        return list;
    }

    public static List<Integer> invertLista(List<Integer> list) {
        List<Integer> invertita = new ArrayList<>(list);
        Collections.reverse(invertita);
        return invertita;
    }

    public static void print(List<Integer> list, boolean pari) {
        for (int i = 0; i < list.size(); i++) {
            if (pari && i % 2 == 0) {
                System.out.print(list.get(i) + " ");
            } else if (!pari && i % 2 != 0) {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 10;
        List<Integer> numeri = generaCasuale(N);
        System.out.println("Lista ordinata: " + numeri);

        List<Integer> invertita = invertLista(numeri);
        System.out.println("Lista invertita: " + invertita);

        System.out.println("Numeri in posizione pari:");
        print(numeri, true);
        System.out.println("Numeri in posizione dispari:");
        print(numeri, false);


    }

}
