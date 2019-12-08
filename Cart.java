package transports;

public class Cart extends Transport {
    final static double kmCost = 5;
    final static int capacity = 500;
    final static int peoplePerRide = 1;
    final static double speed = 10;

    public Cart(long id, int rideLength) {
        super(id, rideLength, kmCost, speed, peoplePerRide, capacity);
    }
}
