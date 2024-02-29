package Vehicles;

public class Motorcycle {
    
    public enum Color {
        RED,
        BLUE,
        BLACK,
        WHITE,
        GREEN,
        YELLOW,
        GREY
    }

    private String licenseNumber;
    private int year;
    private Color color;
    private String make;
    private int horsePower;


    public Motorcycle(String lic, int yr, Color cl, String mk, int hp) {
        setLicenseNumber(lic);
        setYear(yr);
        color = cl;
        setMake(mk);
        setHorsePower(hp);
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String lic) {
        if (lic.length() != 6) {
            throw new IllegalArgumentException("License plates must be exactly 6 figures long.");
        }

        // Below we check the content of the license plate and make sure it is according to swedish standards.
        // Just comment it out if you want to allow other input.
        for (int j = 0; j < 3; j++) {
            if (lic.charAt(j) < 65 || lic.charAt(j) > 90) {
                throw new IllegalArgumentException("Invalid license plate number.");
            }
        }
        for (int j = 3; j < 5; j++) {
            if (lic.charAt(j) < 48 || lic.charAt(j) > 57) {
                throw new IllegalArgumentException("Invalid license plate number.");
            }
        }
        if (lic.charAt(5) < 48 || lic.charAt(5) > 57) {
            if (lic.charAt(5) < 65 || lic.charAt(5) > 90) {
                throw new IllegalArgumentException("Invalid license plate number." + lic.charAt(5));
            }
        }
        
        licenseNumber = lic;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int yr) {
        if (yr < 1900 || yr > 2023) {
            throw new IllegalArgumentException("Input year is invalid.");
        }
        year = yr;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String mk) {
        make = mk;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int hp) {
        if (hp <= 0) {
            throw new IllegalArgumentException("A motorcycle must have some power.");
        }
        horsePower = hp;
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (int i = 0; i < licenseNumber.length(); i++) { // Adds license plate
            sum += (int) licenseNumber.charAt(i);
        }

        sum += year; // Adds year
        
        for (int i = 0; i < color.toString().length(); i++) { // Adds color
             sum += (int) color.toString().charAt(i);
        }

        for (int i = 0; i < make.length(); i++) { // Adds make
            sum += (int) make.charAt(i);
        }

        sum += horsePower; // Adds horsepower

        return sum;
    }
}
