package strategy.parking;

import entities.Floor;
import entities.Spot;
import entities.Vehicle;

import java.util.List;
import java.util.Optional;

public class NearestParkingSpot implements ParkingStrategy {
    @Override
    public Optional<Spot> findSpot(List<Floor> floors, Vehicle vehicle) {
        for ( Floor floor : floors){
            Optional<Spot> parkingSpot = floor.findAvailableSpot(vehicle);
            if(parkingSpot.isPresent())
                return parkingSpot;
        }
        return Optional.empty();
    }
}
