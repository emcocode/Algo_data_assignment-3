import java.util.Arrays;
import java.util.Random;

import Vehicles.Car;
import Vehicles.Car.Color;

public class Problem2 {

    private Random rn;

    public Problem2() {
        rn = new Random();
    }

    public static void main(String[] args) {
        Problem2 p = new Problem2();
        
        int iterations = 10000;

        int maxCars = 14;
        int tableSize = 31;
        double[] collisionList = new double[maxCars + 1];
        double[] offsetList = new double[maxCars + 1];
        double[] diffList = new double[maxCars + 1];

        for (int car = 1; car <= maxCars; car++) {
            double totalCollisions = 0, totalOffset = 0;
            for (int i = 0; i < iterations; i++) {

                MyHash h = new MyHash(tableSize);
                for (int c = 0; c < car; c++) {
                    h.insert(p.randomCarGenerator());
                }
                totalCollisions += h.getCollisions();
                totalOffset += h.getTotalOffset();
            }
            collisionList[car] = totalCollisions/iterations;
            offsetList[car] = totalOffset/iterations;
            if (totalCollisions/iterations != 0) {
                diffList[car] = totalOffset/totalCollisions;
            }
        }

        System.out.println("Collosions: " + Arrays.toString(collisionList));
        System.out.println("Offsets: " + Arrays.toString(offsetList));
        System.out.println("Diff: " + Arrays.toString(diffList));
 

        // Check distribution of random cars
        // int iters = 1_000_000;
        // int tableSize = 31;
        // int[] hashtable = new int[tableSize];
        // Arrays.fill(hashtable, 1);
        // for (int c = 0; c < iters; c++) {
        //     Car car = p.randomCarGenerator();
        //     hashtable[car.hashCode() % tableSize] += 1;
        // }
        // System.out.println(Arrays.toString(hashtable));
    }

    /*
     * Creates and return a car with randomized characteristics.
     */
    public Car randomCarGenerator() {
        String licensePlate = randomLicense(); // Random license plate
        int year = rn.nextInt(1900, 2023); // Random year
        Color color = Color.values()[new Random().nextInt(Color.values().length)]; // Random color
        String make = "Volkswagen"; // Not random. We use VW for all cars here, we have enough random
        int passengerSeats = rn.nextInt(1, 8); // Random number of seats
        return new Car(licensePlate, year, color, make, passengerSeats);
    }

    /*
     * Random license plate for Swedish system. 
     * Only in format XXXYYY, no XXXYYX:s.
     */
    public String randomLicense() {
        StringBuilder licensePlate = new StringBuilder();

        for (int i = 0; i < 3; i++) { // First three characters
            char randomChar = (char) (rn.nextInt(65, 90));
            licensePlate.append(randomChar);
        }

        for (int i = 0; i < 3; i++) { // Last three characters (only 0-9 in this case)
            char randomDigit = (char) (rn.nextInt(48, 57));
            licensePlate.append(randomDigit);
        }

        return licensePlate.toString();
    }

}
