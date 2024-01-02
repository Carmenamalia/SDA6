package algoritmi_strings;

import java.util.HashSet;
import java.util.Set;

public class E6LongestSubstringWithoutRepChars {
    // How do you find the length of the longest substring without repeating characters?

    //ex pwwqee
    public static void main(String[] args) {
        System.out.println("cel mai lung substring fara caractere care se repeta are " + findLenghtOfLongestSubs("pwwqerere") + " caractere");
        //output:
        //[q, e, w]
        //[q, r, e, w]
        //[e]
        //[r, e]
        //[e]
        //cel mai lung substring fara caractere care se repeta are 4 caractere
    }

    // Metoda primește un șir de caractere și returnează lungimea celui mai lung subșir distinct de caractere consecutive:
    public static Integer findLenghtOfLongestSubs(String word) {
        // Setul helper este folosit pentru a urmări caracterele unice din subșir:
        Set<Character> helper = new HashSet<>();
        // Variabila maxLenght stochează lungimea maximă a subșirului distinct.
        int maxLenght = 0;
        // Parcurgem fiecare caracter din șir.
        for (Character c : word.toCharArray()) {
            // Verificăm dacă caracterul curent există deja în subșir.
            if (!helper.add(c)) {
                // Dacă caracterul există deja, înseamnă că am atins sfârșitul subșirului distinct.
                // Calculăm lungimea subșirului actual și o comparăm cu lungimea maximă.
                maxLenght = Math.max(maxLenght, helper.size());
                // Curățăm setul pentru a începe un nou subșir distinct.
                helper.clear();
                // Adăugăm caracterul curent în setul curățat.
                helper.add(c);
            }
            System.out.println(helper);// (Doar pentru afișare în consolă) Afișăm starea curentă a setului helper.
        }
        return maxLenght; // Returnăm lungimea maximă a subșirului distinct.
    }
    /*Complexitatea temporală a acestui algoritm este O(n), unde n este lungimea șirului de intrare,
    deoarece se parcurge șirul o singură dată.
     Complexitatea spațială este și ea O(n), deoarece folosim un set pentru a urmări caracterele unice din subșir.
     */
}
