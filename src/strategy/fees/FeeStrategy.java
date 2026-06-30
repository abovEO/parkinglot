package strategy.fees;

import entities.Ticket;

public interface FeeStrategy {
    double calculatePrice(Ticket ticket);
}
