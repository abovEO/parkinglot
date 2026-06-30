package strategy.fees;

import entities.Ticket;
import enums.VehicleSize;

public class VehicleFeeStrategy implements FeeStrategy {

    private final VehicleSize size;

    public VehicleFeeStrategy(VehicleSize size){
        this.size = size;
    }

    @Override
    public double calculatePrice(Ticket ticket) {
        long duration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * size.getHourlyRate();
    }
}
