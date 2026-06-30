package entities;

public class Ticket {
    private final String id;
    private final long entryTimestamp;
    private long exitTimestamp;
    private final Vehicle vehicle;
    private final Spot spot;

    public Ticket(String id, long entryTimestamp, Vehicle vehicle, Spot spot){
        this.id = id;
        this.entryTimestamp = entryTimestamp;
        this.vehicle = vehicle;
        this.spot = spot;
    }

    public long getEntryTimestamp() {
        return entryTimestamp;
    }

    public long getExitTimestamp() {
        return exitTimestamp;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setExitTimestamp(long exitTimestamp) {
        this.exitTimestamp = exitTimestamp;
    }
}
