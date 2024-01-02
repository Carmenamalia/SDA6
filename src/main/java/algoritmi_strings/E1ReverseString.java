package algoritmi_strings;

public class E1ReverseString {

    //How do you reverse a given string in place?
    // "reverse" ---> "esrever"

    //1.ITERATIV:
    // Functia primeste un șir de caractere și îl inversează(complexitate O(n))
    public static String reverseString(String str) {
        // Inițializează un șir gol pentru a stoca șirul inversat
        String revStr = "";
        // Parcurge șirul original de la ultimul caracter până la primul
        for (int i = str.toCharArray().length - 1; i >= 0; i--) {
            // Adaugă caracterul curent la șirul inversat
            revStr += str.toCharArray()[i];
        }
        // Returnează rezultatul inversării
        return revStr;
    }

    public static String reverseString2(String str) {
        // Inițializează un șir gol pentru a stoca șirul inversat
        String revStr = "";
        // Parcurge șirul de caractere din sirul original
        for (char c : str.toCharArray()) {
            // Adaugă caracterul curent la șirul inversat
            revStr = c + revStr;
        }
        // Returnează rezultatul inversării
        return revStr;
    }

    //2.RECURSIV (complexitate O(n)
    public static String reverseRecursive(String str) {
        //verifică mai întâi baza recursivității (când șirul are lungimea 0 sau 1) și returnează șirul original în aceste cazuri
        if (str == null || str.length() <= 1) {
            return str;
        }
        //Altfel, funcția returnează inversul restului șirului concatenat cu primul caracter
        return reverseRecursive(str.substring(1)) + str.charAt(0);
    }

    //3.METODE PREDEFINITE:
    public static String reverseString3(String str) {
        // Folosind StringBuilder
        String reversedStr = new StringBuilder(str).reverse().toString();
        return reversedStr;
    }

    //4.POINTERI
    public static String reverseIterative(String str) {
        // Converteste șirul într-un tablou de caractere pentru a permite schimbul direct al acestora.
        char[] charArray = str.toCharArray();

        // Inițializarea a doi pointeri, unul la început și celălalt la sfârșitul șirului.
        int left = 0;
        int right = charArray.length - 1;

        // Iterează până când cei doi pointeri se întâlnesc sau trec unul pe lângă celălalt.
        while (left < right) {
            // Schimbarea pozițiilor caracterelelor de la pointerii left și right.
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Mutarea pointerului de la început spre sfârșit și cel de la sfârșit spre început.
            left++;
            right--;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        String str = "reverse";
        System.out.println("iterativ: " + reverseString(str));
        System.out.println("iterativ 2: " + reverseString2(str));
        System.out.println("cu StringBuilder: " + reverseString3(str));
        System.out.println("recursiv: " + reverseRecursive(str));
        System.out.println("iterativ cu 2 pointeri: " + reverseIterative(str));
        //output: esrever
    }
}

