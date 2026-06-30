import entities.Floor;
import entities.Spot;
import entities.Ticket;
import entities.Vehicle;
import strategy.fees.FeeStrategy;
import strategy.fees.RateFeeStrategy;
import strategy.parking.NearestParkingSpot;
import strategy.parking.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    public static ParkingLot instance;
    private final List<Floor> floors = new ArrayList<>();
    private final Map<String , Ticket> availableTickets;
    private FeeStrategy feeStrategy;
    private ParkingStrategy parkingStrategy;

    public ParkingLot(){
        this.availableTickets = new ConcurrentHashMap<>();
        this.feeStrategy = new RateFeeStrategy(15.0);
        this.parkingStrategy = new NearestParkingSpot();
    }

    public void addFloors(Floor floor){
        this.floors.add(floor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public Optional<Spot> parkVehicle(Vehicle vehicle){
        Optional<Spot> availableSpot = parkingStrategy.findSpot(floors,vehicle);
        return Optional.empty();
    }
}
