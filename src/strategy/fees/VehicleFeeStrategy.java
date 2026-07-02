package strategy.fees;

import entities.Ticket;
import enums.VehicleSize;

public class VehicleFeeStrategy implements FeeStrategy {

    @Override
    public double calculatePrice(Ticket ticket) {
        long duration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * ticket.getSpot().getSpotSize().getHourlyRate();
    }
}
