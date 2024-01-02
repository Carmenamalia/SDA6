package algoritmi_strings;

public class E3FirstNonRepeatedChar {
    //How do you print the first non-repeated character from a string?
    public static String findNonDuplicateChar(String str) {
        // Un șir pentru a stoca primele caractere non-duplicate găsite în șir
        //initializez cu primul caracter din sirul original
        String firstNonDuplicateChar = String.valueOf(str.charAt(0));
        // Parcurg fiecare caracter din șirul dat:
        for (int i = 1; i < str.toCharArray().length - 1; i++) {
            //daca caracterul curent e diferit de cel dinainte
            if (str.charAt(i) != str.charAt(i - 1)) {
                //il adaug in sirul de caractere non-duplicate
                firstNonDuplicateChar += str.charAt(i);
            } else {
                //altfel ma opresc
                break;
            }
        }
        // Returnez șirul format din primele caractere non-duplicate
        return firstNonDuplicateChar;
    }

    public static void main(String[] args) {
        String str = "arppeggiu";
        System.out.println(findNonDuplicateChar(str));
        //output: arp
    }
}
