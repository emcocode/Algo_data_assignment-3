public class InsertSort {

    /*
     * Insert sort method for entire array.
     */
    public void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    /*
     * Insert sort for parts of an array.
     */
    public void insertSort(int[] arr, int low, int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else {
                    break;
                }
            }
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
     * Check if parts of an array is sorted.
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