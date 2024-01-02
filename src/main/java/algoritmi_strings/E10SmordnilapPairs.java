package algoritmi_strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E10SmordnilapPairs {
    //Given an array, generate the pairs of words that are written in reversed way.
    // Example: Input: [diaper, abc, test, cba, repaid] Output: [[diaper, repaid], [abc, cba]]

    //parcurg array-ul
    //pt cuvantul crt ii gasesc inversul
    //daca exista deja inversul in set
    // imi fac un array din invers si cuvantul crt si il adaug la rezultat
    //daca nu, bag cuvantul curent in set
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("diaper");
        words.add("abc");
        words.add("test");
        words.add("cba");
        words.add("repaid");
        System.out.println(generatePairs(words));
        //output: [[cba, abc], [repaid, diaper]]
    }

    // Metoda pentru generarea perechilor de cuvinte care sunt inversate unul față de celălalt:
    public static List<List<String>> generatePairs(List<String> words) {
        // Se folosește un set pentru a stoca cuvintele deja întâlnite:
        Set<String> helper = new HashSet<>();
        // Lista în care se vor stoca perechile de cuvinte:
        List<List<String>> result = new ArrayList<>();
        // Parcurge fiecare cuvânt din lista dată:
        for (String word : words) {
            // Obține inversul cuvântului curent:
            String reverse = new StringBuilder(word).reverse().toString();
            // Verifică dacă inversul cuvântului a fost deja întâlnit în listă
            if (helper.contains(reverse)) {
                // Dacă da, creează o nouă listă cu cuvântul curent și inversul său
                List<String> currentPair = new ArrayList<>();
                currentPair.add(word);
                currentPair.add(reverse);
                // Adaugă perechea în lista de rezultate
                result.add(currentPair);
            } else {
                // Dacă inversul nu a fost întâlnit, adaugă cuvântul curent în setul de cuvinte
                helper.add(word);
            }
//               if (!helper.add(word)) {
//                    // Dacă cuvantul nu a fost adaugat in set, creează o nouă listă cu cuvântul curent și inversul său
//                    List<String> currentPair = new ArrayList<>();
//                    currentPair.add(word);
//                    currentPair.add(reverse);
//                    // Adaugă perechea în lista de rezultate
//                    result.add(currentPair);
//               }

        }
        //Returnează lista finală de perechi de cuvinte
        return result;
    }
     /*Acest cod are o complexitate de timp de O(n), unde n este numărul de cuvinte din lista dată, deoarece parcurge lista
     o singură dată. Utilizarea unui set (helper) pentru a verifica dacă un cuvânt și inversul său au fost deja întâlnite
     contribuie la eficiența algoritmului, eliminând necesitatea de a parcurge întreaga listă de perechi de cuvinte
      pentru a verifica duplicarea.
      */
}
