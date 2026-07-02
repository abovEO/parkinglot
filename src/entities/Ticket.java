package entities;

import java.util.Date;
import java.util.UUID;

public class Ticket {
    private final String id;
    private final long entryTimestamp;
    private long exitTimestamp;
    private final Vehicle vehicle;
    private final Spot spot;

    public Ticket(Vehicle vehicle, Spot spot) {
        this.id = String.valueOf(UUID.randomUUID());
        this.entryTimestamp = new Date().getTime();
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

    public void setExitTimestamp() {
        this.exitTimestamp = new Date().getTime();
    }
}
