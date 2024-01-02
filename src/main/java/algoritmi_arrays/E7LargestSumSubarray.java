package algoritmi_arrays;

import java.util.List;

public class E7LargestSumSubarray {
    //Given an integer array nums, find the subarray with the largest sum, and return its sum (de observat Kadane Algorrithm)
    // [-2,1,-3,4,-1,2,1,-5,4]

    //maxSoFar - maximul dintre toate subarray-urile de pana acum(se initializeaza cu primul elem)
    //maxEndingHere -  suma maxima a subarray0urilor care se termina la pozitia curenta(se initializeaza cu primul elem)

    // Metoda primește o listă de numere întregi și returnează suma maximă a unui subșir continuu (Kadane's Algorithm):
    public static Integer maxSumSubarray(List<Integer> nums) {
        // Variabila maxSoFar stochează suma maximă a subșirului până la indicele curent.
        // Este actualizată la fiecare iterație a buclei pentru a reflecta cea mai mare sumă găsită până la acel moment.
        int maxSoFar = nums.get(0);
        // Variabila maxEndingHere stochează suma maximă a subșirului care se încheie la indicele curent.
        //La fiecare iterație, alegem între a extinde subșirul curent sau a începe un subșir nou.
        int maxEndingHere = nums.get(0);
        // Parcurgem lista de numere.
        for (int i = 0; i < nums.size(); i++) {
            // Actualizăm suma maximă a subșirului curent:
            // - Alegem între să extindem subșirul actual sau să începem un subșir nou.
            maxEndingHere = Math.max(nums.get(i), maxEndingHere + nums.get(i));
            // Actualizăm suma maximă globală:
            // - Alegem între suma maximă a subșirului curent și suma maximă globală anterioară.
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar; // Returnăm suma maximă a subșirului continuu.
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4);
        System.out.println(maxSumSubarray(nums));
        //output: 6
    }

    /*Algoritmul Kadane are o complexitate de timp de O(n), unde n este numărul de elemente din listă,
     deoarece parcurge lista o singură dată.
     Complexitatea spațială este O(1), deoarece folosește doar un număr constant de variabile.
     Este un algoritm eficient pentru rezolvarea acestei probleme.
     */
}
