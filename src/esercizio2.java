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

    
}
