public class QuickSort {

    private int maxDepth;

    /*
     * Public quicksort method.
     */
    public void quickSort(int[] arr, int depth) {
        maxDepth = depth;
        _quickSort(arr, 0, arr.length - 1, 0);
    }

    /*
     * Private recursive quicksort method.
     * Comment in/out which type of sorting should be swapped to upon reaching cut off depth.
     */
    private void _quickSort(int[] arr, int low, int high, int currentDepth) {
        if (high > low) {
            if (currentDepth < maxDepth) {
                int piv = _median(arr, low, high);
                int j = _partition(arr, low, piv, high);
                _quickSort(arr, low, j - 1, currentDepth + 1);
                _quickSort(arr, j + 1, high, currentDepth + 1);
            } else {
                currentDepth -= 1;
                HeapSort hs = new HeapSort(); // Swap to Heap sort
                hs.heapSort(arr, low, high);
                // InsertSort is = new InsertSort(); // Swap to Insert sort
                // is.insertSort(arr, low, high);
            }
        }
    }

    /*
     * Partition parts of the array.
     */
    private int _partition(int[] arr, int low, int piv, int high) {
        int pivot = arr[piv];
        arr[piv] = arr[high];
        arr[high] = pivot;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        return i + 1;
    }

    /*
     * Get the index of the median value of the the first, middle and last elements.
     */
    private int _median(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        if (arr[low] <= arr[mid] && arr[mid] <= arr[high]) {
            return mid;
        } else if (arr[low] <= arr[mid] && arr[mid] >= arr[high]) {
            return high;
        } else if (arr[mid] <= arr[low] && arr[low] <= arr[high]) {
            return low;
        } else if (arr[mid] <= arr[high] && arr[high] <= arr[low]) {
            return high;
        } else if (arr[high] <= arr[low] && arr[low] <= arr[mid]) {
            return low;
        } else return mid;
    }

    /*
     * Check if sorted.
     */
    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
