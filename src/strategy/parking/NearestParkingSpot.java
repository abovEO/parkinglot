package strategy.parking;

import entities.Floor;
import entities.Spot;
import entities.Vehicle;

import java.util.List;
import java.util.Optional;

public class NearestParkingSpot implements ParkingStrategy {
    @Override
    public Optional<Spot> findSpot(List<Floor> floors, Vehicle vehicle) {
        for (Floor floor : floors) {
//            System.out.println("floor " + floor.getId());
            Optional<Spot> parkingSpot = floor.findAvailableSpot(vehicle);
            if (parkingSpot.isPresent()) {
                System.out.println( parkingSpot.get().getId() + " spot available" );
                return parkingSpot;
            }
        }
        return Optional.empty();
    }
}
