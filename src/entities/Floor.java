package entities;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Floor {
    private final String id;
    private final Map<String, Spot> spots;

    public Floor(String id, Map<String, Spot> spots) {
        this.id = id;
        this.spots = spots;
    }

    public String getId() {
        return id;
    }

    public Map<String, Spot> getSpots() {
        return spots;
    }

    public void addSpots(String id, Spot spot) {
        this.spots.put(id, spot);
    }

    public synchronized Optional<Spot> findAvailableSpot(Vehicle vehicle) {
        return spots.values().stream().filter(spot -> !spot.isAvailable() && spot.canFitVehicle(vehicle)).min(Comparator.comparing(Spot::getSpotSize));
    }

    public void displayAvailability(){
        for (Map.Entry<String , Spot> spot : spots.entrySet()){
            if (spot.getValue().isAvailable()){
                System.out.println(spot.getKey() + " is available for size: " + spot.getValue().getSpotSize());
            }
        }
    }
}
