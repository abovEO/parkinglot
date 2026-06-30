package enums;


public enum VehicleSize {
    SMALL(10.0),
    MEDIUM(20.0),
    LARGE(30.0);

    private final double hourlyRate;

    VehicleSize(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}