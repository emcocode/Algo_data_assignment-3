import java.util.Arrays;

public class MyHash<T> {
    
    private T[] hashTable;
    private int collisions;
    private int totalOffset;

    public MyHash(int n) {
        hashTable = (T[]) new Object[n]; // Generic object array
        collisions = 0;
    }

    /*
     * To retrieve objects from the array and making their information available. 
     * For example, we use this method to get and object, then we can read what object it is and/or change it.
     * Since we store the entire objects in the array, we want to be able to get them and use them.
     */
    public T getObject(T objectToGet) {
        int key = objectToGet.hashCode() % hashTable.length;
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[(key + i * i) % hashTable.length] == objectToGet) {
                return hashTable[(key + i * i) % hashTable.length];
            }
        }
        return null;
    }

    /*
     * Insert method. We use the hashcode method from the vehicles to select a bucket.
     * We use the size of the hashtable to decide which bucket.
     */
    public T[] insert(T newObject) {
        int key = newObject.hashCode() % hashTable.length;
        if (hashTable[key] == null) {
            hashTable[key] = newObject;
        } else {
            for (int i = 0; i < hashTable.length; i++) {
                if (hashTable[(key + i * i) % hashTable.length] == null) {
                    hashTable[(key + i * i) % hashTable.length] = newObject;
                    totalOffset += (i * i);
                    break;
                }
                collisions += 1;
            }
        }
        return hashTable;
    }

    /*
     * A boolean method to check wheather an object exists or not.
     */
    public boolean find(T objectToFind) {
        int key = objectToFind.hashCode() % hashTable.length;
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[(key + i * i) % hashTable.length] == objectToFind) {
                return true;
            }
        }
        return false;
    }

    /*
     * Delete an object (if it exists).
     */
    public T[] delete(T objectToDelete) {
        if (find(objectToDelete)) {
            int key = objectToDelete.hashCode() % hashTable.length;
            for (int i = 0; i < hashTable.length; i++) {
                if (hashTable[(key + i * i) % hashTable.length] == objectToDelete) {
                    hashTable[(key + i * i) % hashTable.length] = null;
                    break;
                }
            }
        }
        return hashTable;
    }

    /*
     * Get the number of collisions.
     */
    public int getCollisions() {
        return collisions;
    }

    /*
     * Get the total offsets.
     * Total offset sums up all offsets during the insertions.
     */
    public int getTotalOffset() {
        return totalOffset;
    }

    /*
     * Simple method to print objects in hashtable.
     * NOTE: It only prints the object ID, no information such as license plate etc. 
     * To get such information, we use the getObject method above.
     */
    public void printTable() {
        System.out.println(Arrays.toString(hashTable));
    }

}
