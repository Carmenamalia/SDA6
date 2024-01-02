package algoritmi_strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E8LongestCommonPrefix {
    //Given a set of strings, find the longest common prefix. Examples:
    //
    //input: {“geeksforgeeks”, “geeks”, “geek”, “geezer”} Output: “gee”
    //
    //Input: {“apple”, “ape”, “april”} Output: “ap”
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("geeksforgeeks");
        arr.add("geeks");
        arr.add("geek");
        arr.add("geezer");
        List<String> arr2 = new ArrayList<>();
        arr2.add("apple");
        arr2.add("ape");
        arr2.add("april");

        System.out.println(findLongestCommonPrefix(arr));
        //output: gee
        System.out.println(findLongestCommonPrefix(arr2));
        //output: ap
    }

    // Metoda pentru găsirea celui mai lung prefix comun într-o listă de șiruri
    public static String findLongestCommonPrefix(List<String> arr) {
        // Sortează lista pentru a asigura că cele două șiruri cu cele mai diferite litere sunt pe margini
        Collections.sort(arr);
        // Extrage primul și ultimul șir din lista sortată
        String firstString = arr.get(0);
        String lastString = arr.get(arr.size() - 1);
        // Folosește metoda findCommonPrefix pentru a găsi prefixul comun între cele două șiruri
        return findCommonPrefix(firstString, lastString);
    }

    // Metoda care găsește prefixul comun între două șiruri
    public static String findCommonPrefix(String s1, String s2) {
        int i = 0;
        String commonPrefix = "";
        // Parcurge caracterele șirurilor până când se găsește o diferență sau se ajunge la finalul unuia dintre șiruri
        while (s1.charAt(i) == s2.charAt(i) && ((i < s1.length()) && i < s2.length())) {
            commonPrefix += s1.charAt(i);
            i++;
        }
        // Returnează prefixul comun găsit
        return commonPrefix;
    }
    /*Acest cod are o complexitate de timp O(m * n * log(n)), unde n este numărul de șiruri din lista dată,
    iar m este lungimea maximă a unui șir.
     Sortarea listei adaugă o complexitate logaritmică.
     Apoi, găsirea prefixului comun între primul și ultimul șir necesită parcurgerea acestora până la primul caracter diferit
      sau până la sfârșitul unuia dintre șiruri.
     Utilizarea sortării îmbunătățește eficiența algoritmului,
     deoarece permite compararea rapidă a celor două șiruri extreme pentru a găsi un prefix comun.
     */
}
