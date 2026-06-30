package strategy.parking;

import entities.Floor;
import entities.Spot;
import entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<Spot> findSpot(List<Floor> floors, Vehicle vehicle);
}
