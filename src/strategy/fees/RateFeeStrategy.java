package strategy.fees;

import entities.Ticket;

public class RateFeeStrategy implements FeeStrategy {

    private final double rate;

    public RateFeeStrategy(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculatePrice(Ticket ticket) {
        long duration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return duration * rate;
    }
}
