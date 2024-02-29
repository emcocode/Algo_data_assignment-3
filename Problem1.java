import Vehicles.Car;
import Vehicles.Car.Color;

public class Problem1 {
    
    /*
     * In this class, we mainly check functionality for vehicles and hashtable.
     */
    public static void main(String[] args) {
        MyHash h = new MyHash(31);
        Car car1 = new Car("ABC123", 1995, Color.GREEN, "Volvo", 4);
        Car car2 = new Car("HEJ123", 2004, Color.RED, "Audi", 4);
        Car car3 = new Car("GCE024", 2015, Color.BLACK, "VW", 4);
        Car car4 = new Car("STO123", 2005, Color.WHITE, "VW", 8);
        Car car5 = new Car("GCE024", 2015, Color.BLACK, "VW", 4);
        System.out.println(car1.hashCode());
        h.insert(car1);
        h.insert(car2);
        h.insert(car3);
        h.insert(car4);
        h.printTable();
        h.insert(car5);
        h.printTable();
        System.out.println(h.find(car3));
        System.out.println(h.getCollisions());

    }
}