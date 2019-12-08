package transports;

public class Car extends Transport {
    final static double kmCost = 2;
    final static int capacity = 150;
    final static int peoplePerRide = 5;
    final static double speed = 100;

    public Car(long id, int rideLength) {
        super(id, rideLength, kmCost, speed, peoplePerRide, capacity);
    }
}
