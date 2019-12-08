package transports;

public class Bicycle extends Transport {
    final static double kmCost = 1;
    final static int capacity = 10;
    final static int peoplePerRide = 1;
    final static double speed = 20;

    public Bicycle(long id, int rideLength) {
        super(id, rideLength, kmCost, speed, peoplePerRide, capacity);
    }
}
