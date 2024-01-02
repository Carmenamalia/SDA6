package algoritmi_arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class E11MergeIntervals {
    // Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    // and return an array of the non-overlapping intervals that cover all the intervals in the input.
    //Example: Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
    // Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
    public static void main(String[] args) {
        //structura de date ajutatoare
        //brute force:luam fiecare cu fiecare(generam toate perechile din array)
        //sortam array-ul
        //parcurgem cu 2 pointeri
        //sortez intervalele dupa capetele din stanga(start)
        //parcurg fiecare interval
        //verific daca intervalul crt se suprapune cu intervalul urmator
        //daca da : retin startul primului interval si endul celui de al doilea interval ca fiind intervalul curent
        //daca nu : trec la intervalul urmator

        List<List<Integer>> intervals = new ArrayList<>();
        List<Integer> i1 = new ArrayList<>();
        List<Integer> i2 = new ArrayList<>();
        List<Integer> i3 = new ArrayList<>();
        List<Integer> i4 = new ArrayList<>();
        i1.add(1);
        i1.add(3);
        i2.add(2);
        i2.add(6);
        i3.add(8);
        i3.add(10);
        i4.add(15);
        i4.add(18);
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        System.out.println(merge(intervals));
        //output: [[1, 6], [8, 10], [15, 18]]
    }

    // Metoda merge primește o listă de intervale și le fuzionează pe cele care se suprapun.
    public static List<List<Integer>> merge(List<List<Integer>> intervals) {
        // Sortăm intervalele în ordine crescătoare .
        // intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0))); //sau:
        intervals.sort(Comparator.comparingInt(a -> a.get(0)));
        // Inițializăm intervalul curent cu primul interval din lista sortată.
        List<Integer> currentInterval = intervals.get(0);
        // Lista rezultat în care vom stoca intervalele fuzionate.
        List<List<Integer>> result = new ArrayList<>();
        // Parcurgem lista de intervale.
        for (List<Integer> interval : intervals) {
            // Verificăm dacă intervalele se suprapun.
            if (interval.get(0) <= currentInterval.get(1)) {
                // Dacă se suprapun, extindem intervalul curent.
                currentInterval.set(1, interval.get(1));
            } else {
                // Dacă nu se suprapun, adăugăm intervalul curent la rezultat și actualizăm intervalul curent.
                result.add(currentInterval);
                currentInterval = interval;
            }
        }
        // Adăugăm ultimul interval la rezultat.
        result.add(currentInterval);
        // Returnăm lista finală cu intervalele fuzionate.
        return result;
    }
    /*
    1.Sortarea: O(n log n), unde n este numărul de intervale.
     Sortarea este realizată pe baza primelor elemente ale intervalelor,
     iar cel mai eficient algoritm de sortare în acest caz este un algoritm de sortare cu complexitatea timp de O(n log n).
    2. Parcurgerea listei sortate: O(n), deoarece parcurgem lista sortată o singură dată.
     Prin urmare, complexitatea totală a algoritmului este O(n log n) din cauza operației de sortare, unde n este numărul total de intervale.
      Este important să reținem că operațiunea de sortare domină în general complexitatea în astfel de cazuri,
      iar restul operațiilor au o influență mai mică asupra complexității generale.
     */
}
