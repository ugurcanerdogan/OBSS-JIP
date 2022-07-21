package BusReservation;

public enum Destination {

    ISTANBUL(34), ADANA(01), ANKARA(06);

    private final int plateNumber;

    Destination(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getPlateNumber() {
        return this.plateNumber;
    }
}
