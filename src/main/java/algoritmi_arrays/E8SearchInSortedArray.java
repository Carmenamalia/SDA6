package algoritmi_arrays;

public class E8SearchInSortedArray {
    //There is an integer array nums sorted in ascending order (with distinct values).
    // Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
    // such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
    // For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
    // Given the array nums after the possible rotation and an integer target,
    // return the index of target if it is in nums, or -1 if it is not in nums.

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Verificăm dacă am găsit ținta
            if (nums[mid] == target) {
                return mid; // Elementul a fost găsit
            }
            // Verificăm dacă partea stângă a intervalului este sortată
            if (nums[left] <= nums[mid]) {
                // Verificăm dacă ținta se află în partea sortată din stânga
                if (nums[left] <= target && target < nums[mid]) {
                    // Ajustăm intervalul căutării
                    right = mid - 1;
                } else {
                    // Căutăm în partea dreaptă a intervalului
                    left = mid + 1;
                }
            } else {
                // Dacă partea dreaptă a intervalului este sortată
                // Verificăm dacă ținta se află în partea sortată din dreapta
                if (nums[mid] < target && target <= nums[right]) {
                    // Ajustăm intervalul căutării
                    left = mid + 1;
                } else {
                    // Căutăm în partea stângă a intervalului
                    right = mid - 1;
                }
            }
        }

        return -1; // Dacă nu am găsit ținta, returnăm -1
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 6;
        int result = search(nums, target);
        if (result != -1) {
            System.out.println("Indexul elementului " + target + " este: " + result);
        } else {
            System.out.println(target + " not found");
        }
        //output:Indexul elementului 6 este: 2
    }
    /*Complexitatea timp a algoritmului este O(log n), unde n reprezintă lungimea vectorului.
     Căutarea binară clasică are o complexitate logaritmică, iar această variantă adaptată pentru vectorul rotit nu adaugă factori
     care să crească complexitatea asimptotică.
      Astfel, performanța algoritmului rămâne eficientă chiar și pentru vectori mai mari.
     Complexitatea spațială este O(1), deoarece algoritmul folosește un număr constant de variabile pentru a stoca informații suplimentare
     (de exemplu, variabilele left, right, mid).
      Este important de menționat că algoritmul efectuează operații direct pe vectorul dat și nu necesită spațiu suplimentar
       care să crească odată cu mărimea vectorului de intrare.
     */
}
