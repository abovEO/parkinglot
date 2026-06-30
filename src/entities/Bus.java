package entities;

import enums.VehicleSize;

public class Bus extends Vehicle {
    public Bus(String licenseNumber) {
        super(licenseNumber, VehicleSize.LARGE);
    }
}
