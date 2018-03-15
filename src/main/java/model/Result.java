package model;

public class Result {

    private String shipName;
    private int numberTrips;
    private int totalTimeTransport;

    public Result() {
    }

    public Result(String shipName, int numberTrips, int totalTimeTransport) {
        this.shipName = shipName;
        this.numberTrips = numberTrips;
        this.totalTimeTransport = totalTimeTransport;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getNumberTrips() {
        return numberTrips;
    }

    public void setNumberTrips(int numberTrips) {
        this.numberTrips = numberTrips;
    }

    public int getTotalTimeTransport() {
        return totalTimeTransport;
    }

    public void setTotalTimeTransport(int totalTimeTransport) {
        this.totalTimeTransport = totalTimeTransport;
    }
}
