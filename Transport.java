package transports;

public abstract class Transport implements TransportInterface {
    long id;

    int capacity;
    int peoplePerRide;
    double speed;
    double kmCost;

    int rideLength;

    Transport(long id, int rideLength, double kmCost, double speed, int peoplePerRide, int capacity) {
        this.id = id;
        this.rideLength = rideLength;
        this.kmCost = kmCost;
        this.speed = speed;
        this.peoplePerRide = peoplePerRide;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public double getTime() {
        return rideLength / speed;
    }

    public double getRideCost() {
        return rideLength * kmCost;
    }

    public double getPeopleRideCost() {
        return getRideCost() / peoplePerRide;
    }

    public double getShipmentCost() {
        return getRideCost() / capacity;
    }

    public void calc() {
        System.out.println();
        System.out.println("Транспорт " + this.getId() + ":");
        System.out.printf("Стоимость певевозки пассажира %.2f \n", this.getPeopleRideCost());
        System.out.printf("Стоимость певевозки 1 кг. %.2f  \n", this.getShipmentCost());
        System.out.printf("Время поездки %.2f  \n", this.getTime());
    }

}
