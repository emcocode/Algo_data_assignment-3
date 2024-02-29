import java.util.Arrays;
import java.util.Random;

public class Problem5 {
    public static void main(String[] args) {
        TimeMeasuring t = new TimeMeasuring();
        Random rn = new Random();

        long[] timeTable = new long[20];
        int iterations = 50;
        for (int depth = 2; depth <= 40; depth = depth + 2) { // Running depths 2-40, with 2 as interval
            System.out.println("Current depth " + depth); // Just to keep track, when it takes a long time
            long totalTime = 0;
            for (int k = 0; k < iterations; k++) {
                System.out.println("Iter " + (k + 1));
                QuickSort qs = new QuickSort();
                int size = 1_000_000; // Array size to sort
                int[] arr = new int[size];
                for (int j = 0; j < size; j++) {
                    arr[j] = rn.nextInt(size);
                }
                t.startTimer();
                qs.quickSort(arr, depth);
                long timeMilliseconds = t.stopTimer() / 1_000_000;
                totalTime += timeMilliseconds;
            } 
        timeTable[depth / 2 - 1] = totalTime / iterations; // Puts values in an array to simplify visualisation
        System.out.println("Avg time taken in ms: " + (totalTime / iterations));
        }
        System.out.println(Arrays.toString(timeTable));
        
       
    }
}
