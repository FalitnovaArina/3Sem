package transports;

public interface TransportInterface {
    long getId();

    double getTime();
    double getRideCost();
    double getPeopleRideCost();
    double getShipmentCost();
    void calc();
}
