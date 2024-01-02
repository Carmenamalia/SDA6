package algoritmi_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E2FindDuplicate {
    // How do you find duplicate characters from a string? (using map)

    //parcurg sirul
    //intr-o mapa, la cheie bag caracterul si la valoare numarul de aparitii
    //caracterele duplicate sunt cele cu mai mult de o aparitie

    // Metoda primește un șir de caractere și returnează un șir format din caracterele duplicate din șirul dat:
    public static String findDuplicateChar(String str) {
        // mapa pentru a ține evidența numărului de apariții ale fiecărui caracter în șir
        Map<Character, Integer> helper = new HashMap<>();
        // Un șir pentru a stoca caracterele duplicate găsite în șir
        String duplicateChar = "";
        // Parcurg fiecare caracter din șirul dat:
        for (Character c : str.toCharArray()) {
            // Actualizez numărul de apariții ale caracterului în mapa
            helper.compute(c, (key, value) -> (value == null) ? 1 : value + 1);
            // Verific dacă numărul de apariții ale caracterului este 2 (adica, caracterul este duplicat)
            if (helper.get(c).intValue() == 1) {
                // Adaug caracterul la șirul de caractere duplicate
                duplicateChar += c;
            }
        }
        // Returnez șirul format din caracterele duplicate
        return duplicateChar;
    }

    //metoda care foloseste StringBuilder si un Set
    public static String findDuplicateChar2(String str) {
        // Crearea unui șir de caractere gol cu StringBuilder
        StringBuilder resultBuilder = new StringBuilder();
        // Crearea unui set pentru a ține evidența caracterelor duplicate
        Set<Character> duplicatesSet = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (str.indexOf(c) != str.lastIndexOf(c) && duplicatesSet.add(c)) {
                // Dacă caracterul este duplicat și încă nu a fost adăugat în șirul rezultat il adaug in builder
                resultBuilder.append(c);
            }
        }
        // Convertirea StringBuilder la un șir obișnuit
        String resultString = resultBuilder.toString();
        return resultString;
    }

    public static void main(String[] args) {
        String str = "adddidass";
        System.out.println(findDuplicateChar(str));
        //output: adis
        String inputString = "abacabadabacaba";
        System.out.println(findDuplicateChar2(inputString));
        //output: abc
    }
    /*complexitatea totală a algoritmului este O(n * m), unde n este lungimea șirului și m este numărul total de caractere unice din șir
    (numărul de elemente din mapă). În practică, atunci când m este relativ mic și constant,
     putem considera că algoritmul are o complexitate aproximativă de O(n).
     */
}
