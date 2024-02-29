import java.util.Arrays;
import java.util.Random;

public class Problem4 {
    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        // int[] arr = {1, 4, 8, 2, 5, 9, 3, 7, 6};
        Random rn = new Random();

        int size = 100;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rn.nextInt(size);
        }
        
        System.out.println("Original: " + Arrays.toString(arr));
        System.out.println("Is array sorted? " + hs.isSorted(arr));

        hs.heapSort(arr);        
        System.out.println("Sorted: " + Arrays.toString(arr));
        System.out.println("Is array sorted? " + hs.isSorted(arr));

    }
}
