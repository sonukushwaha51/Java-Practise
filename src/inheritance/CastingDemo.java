package inheritance;

public class CastingDemo {

    public static void main(String[] args) {

        // Data type casting: We can cast from lower to higher or of same byte size (e.g. float to int). For this no explicit casting is needed
        // byte -> short -> char -> int -> long -> float -> double
        // e.g.
        int n = 5;
        float f =  n;
        System.out.println(f);
        double nDouble = n;
        System.out.println(nDouble);

        // For converting data type from higher to lower explicit casting is needed
        long l = (long) nDouble;
        System.out.println(l);

        // Object casting --> Two types - Upcasting and DownCasting
        // Upcasting --> When we instantiate an object of parent class using child class. No explicit casting needed
        Vehicle vehicle = new Car();
        String vehicleName = vehicle.getVehicle();
        System.out.println(vehicleName);

        // Down casting --> When we instantiate an object of child class using parent class. Explicit casting needed
        Car car = (Car) vehicle;
        vehicleName = car.getVehicle();
        System.out.println(vehicleName);

    }
}

class Vehicle {

    public String getVehicle() {
        return "Generic vehicle";
    }
}

class Car extends Vehicle {

    @Override
    public String getVehicle() {
        return "Car";
    }
}
