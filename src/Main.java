import entities.*;
import enums.VehicleSize;
import strategy.fees.VehicleFeeStrategy;
import strategy.parking.NearestParkingSpot;

import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ParkingLot parkingLot = new ParkingLot();

        Floor floor1 = new Floor("F1");
        floor1.addSpots(new Spot("A1", VehicleSize.MEDIUM));
        floor1.addSpots(new Spot("A2", VehicleSize.MEDIUM));

        Floor floor2 = new Floor("F2");
        floor2.addSpots(new Spot("B1", VehicleSize.SMALL));
        floor2.addSpots(new Spot("B2", VehicleSize.SMALL));

        Floor floor3 = new Floor("F3");
        floor3.addSpots(new Spot("C1", VehicleSize.LARGE));
        floor3.addSpots(new Spot("C2", VehicleSize.LARGE));

        parkingLot.addFloors(floor1);
        parkingLot.addFloors(floor2);
        parkingLot.addFloors(floor3);

        parkingLot.setParkingStrategy(new NearestParkingSpot());
        parkingLot.setFeeStrategy(new VehicleFeeStrategy());

        System.out.println("\n--- Available Spots ---");
        floor1.displayAvailability();
        floor2.displayAvailability();
        floor3.displayAvailability();

        Vehicle bike = new Bike("B-123");
        Vehicle car = new Car("C-456");
        Vehicle bus = new Bus("T-789");

        Optional<Ticket> ticket1 = parkingLot.parkVehicle(bike);
        Optional<Ticket> ticket2 = parkingLot.parkVehicle(car);
        Optional<Ticket> ticket3 = parkingLot.parkVehicle(bus);

        System.out.println("\n--- Availability after parking ---");
        floor1.displayAvailability();
        floor2.displayAvailability();
        floor3.displayAvailability();

        Vehicle bike2 = new Bike("C-999");
        Optional<Ticket> ticket4 = parkingLot.parkVehicle(bike2);
        Vehicle bike3 = new Bike("C-999");
        Optional<Ticket> ticket5 = parkingLot.parkVehicle(bike3);

        if (ticket3.isPresent()) {
            Optional<Double> fee = parkingLot.unparkVehicle(car.getLicenseNumber());
            fee.ifPresent(aDouble -> System.out.println(ticket3.get().getVehicle().getLicenseNumber() + "unparked. Please pay: " + aDouble));
        }

        System.out.println("\n--- Availability after one car leaves ---");
        floor1.displayAvailability();
        floor2.displayAvailability();
        floor3.displayAvailability();

    }
}