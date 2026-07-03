package entities;

import enums.VehicleSize;

public class Spot {
    private final String id;
    private boolean isOccupied;
    private Vehicle parkedVehicle;
    private final VehicleSize spotSize;

    public Spot(String id, VehicleSize size) {
        this.id = id;
        this.isOccupied = false;
        this.parkedVehicle = null;
        this.spotSize = size;
    }

    public String getId() {
        return id;
    }

    public synchronized boolean isAvailable() {
        return !isOccupied;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public void parkVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
        this.isOccupied = true;
    }

    public void unparkVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        if (isOccupied) return false;
        return switch (vehicle.getSize()) {
            case SMALL -> spotSize == VehicleSize.SMALL;
            case MEDIUM -> (spotSize == VehicleSize.MEDIUM) || (spotSize == VehicleSize.LARGE);
            case LARGE -> spotSize == VehicleSize.LARGE;
            default -> false;
        };
    }
}
