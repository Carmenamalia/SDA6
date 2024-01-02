package algoritmi_strings;

import java.util.*;

public class E9GroupAnagrams {
    //Input: [yo,act,flop,tac,foo,cat,oy,olfp] Output: the anagrams are grouped: [[yo, oy], [flop, olfp], [act,tac,cat], [foo]]
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("yo");
        words.add("act");
        words.add("flop");
        words.add("tac");
        words.add("foo");
        words.add("cat");
        words.add("oy");
        words.add("olfp");
        System.out.println(groupAnagrams(words));
        //Output: [[act, tac, cat], [flop, olfp], [foo], [yo, oy]]
    }

    // Metoda pentru gruparea anagramelor dintr-o listă de cuvinte:
    public static List<List<String>> groupAnagrams(List<String> words) {
        // Se folosește un map pentru a grupa cuvintele după anagramele lor
        Map<String, List<String>> anagramsMap = new HashMap<>();
        // Parcurge fiecare cuvânt din lista dată
        for (String word : words) {
            // Sortează literele cuvântului în ordine alfabetică
            char charArray[] = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            // Verifică dacă anagrama a fost deja întâlnită în map
            if (anagramsMap.containsKey(sortedWord)) {
                // Dacă da, adaugă cuvântul curent la lista de anagrame existentă
                anagramsMap.get(sortedWord).add(word);
            } else {
                // Dacă nu, creează o nouă listă și adaugă cuvântul curent
                List<String> value = new ArrayList<>();
                value.add(word);
                anagramsMap.put(sortedWord, value);
            }

        }
        // Lista în care se vor stoca grupurile de anagrame
        List<List<String>> result = new ArrayList<>();
        // Adaugă fiecare grup de anagrame în lista finală de rezultate
        for (String key : anagramsMap.keySet()) {
            result.add(anagramsMap.get(key));
        }
        // Returnează lista finală de grupuri de anagrame
        return result;
    }
    /*Acest cod are o complexitate de timp de O(n * m * log(m)), unde n este numărul de cuvinte din lista dată,
     iar m este lungimea maximă a unui cuvânt din listă.
      Aceasta se datorează operației de sortare a caracterelor în fiecare cuvânt.
      Utilizarea unui map pentru a grupa anagramele contribuie la eficiența algoritmului,
      permițând o verificare rapidă a existenței unui grup de anagrame asociate cu o anagramă sortată specifică.
     */
}
