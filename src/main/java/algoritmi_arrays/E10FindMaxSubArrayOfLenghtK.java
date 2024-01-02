package algoritmi_arrays;

import java.util.List;

public class E10FindMaxSubArrayOfLenghtK {
    // Find max sum of subarray of length k
    //1,12,-5,-6,50,3  k=4

    public static double findMaxAverage(List<Integer> arr, int k) {
        //parcurg arrayul pana la k si aflu suma curenta
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += arr.get(i);
        }
        int maxSum = currentSum;//initializez suma maxima  cu valoarea sumei curente
        //parcurg arrayul incepand de la indexul egal cu k
        //la suma curenta adaug valoarea de la indexul la care sunt si scad valoarea de la primul index al subarrayului(adica i- k)
        for (int i = k; i < arr.size(); i++) {
            currentSum += arr.get(i) - arr.get(i - k);
            maxSum = Math.max(maxSum, currentSum);//retin suma maxima
        }
        return maxSum;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 12, -5, -6, 50, 3);
        int k = 4;
        System.out.println(findMaxAverage(arr, k));
        //output: 51.0
    }
    /*Complexitatea acestui algoritm este O(n), unde n reprezintă lungimea listei arr.
    Algoritmul utilizează o fereastră glisantă pentru a calcula suma maximă a unui subșir de lungime k într-o listă de numere.
     complexitatea totală a algoritmului este O(k) (prima buclă) + O(n - k) (a doua buclă) = O(n), unde n reprezintă lungimea listei arr.
      Este important de menționat că algoritmul este eficient, având o complexitate liniară, și funcționează bine în practică,
      în special pentru liste mari.
     */
}
