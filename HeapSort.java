public class HeapSort {

    private int[] arr;

    /*
     * Heapsort for entire array.
     */
    public void heapSort(int[] newArr) {
        arr = newArr;
        int n = arr.length;
        for (int i = n / 2; i >= 1; i--) {
            _sink(i, n);
        }
        while (n > 1) {
            int tmp = arr[0];
            arr[0] = arr[n - 1];
            arr[n - 1] = tmp;
            n -= 1;
            _sink(1, n);
        }
    }

    /*
     * Heapsort for parts of an array.
     */
    public void heapSort(int[] arr, int low, int high) {
        int n = high - low + 1;
        for (int i = n / 2; i >= 1; i--) {
            _sink(arr, i, n, low);
        }
        while (n > 1) {
            int tmp = arr[low];
            arr[low] = arr[low + n - 1];
            arr[low + n - 1] = tmp;
            n -= 1;
            _sink(arr, 1, n, low);
        }
    }

    /*
     * Sinker.
     */
    private void _sink(int k, int n) {
        int j = 0;
        while (2 * k <= n) {
            j = 2 * k;
            if (j < n && arr[j - 1] < arr[j]) {
                j += 1;
            }
            if (arr[k - 1] >= arr[j - 1]) {
                break;
            }
            int tmp = arr[k - 1];
            arr[k - 1] = arr[j - 1];
            arr[j - 1] = tmp;
            k = j;
        }
    }

    /*
     * Partial sinker.
     */
    private void _sink(int[] arr, int k, int n, int low) {
        int j = 0;
        while (2 * k <= n) {
            j = 2 * k;
            if (j < n && arr[low + j - 1] < arr[low + j]) {
                j += 1;
            }
            if (arr[low + k - 1] >= arr[low + j - 1]) {
                break;
            }
            int tmp = arr[low + k - 1];
            arr[low + k - 1] = arr[low + j - 1];
            arr[low + j - 1] = tmp;
            k = j;
        }
    }

    /*
     * Check if entire array is sorted.
     */
    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /*
     * Check if part of an array is sorted.
     */
    public boolean isSorted(int[] arr, int low, int high) {
        for (int i = low; i < high; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

}