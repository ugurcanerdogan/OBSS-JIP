package BusReservation;

import java.util.Arrays;

public class Bus {

    int seatCounter = 0;
    private Destination destination;
    private Passenger[] passengers;

    public Bus(Destination destination, int size) {
        if (size == 0) {
            throw new IllegalStateException("Size cannot be 0. Enter a valid size !");
        } else {
            this.destination = destination;
            this.passengers = new Passenger[size];
        }
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Bus{" + "destination=" + destination + ", passengers=" + Arrays.toString(passengers) + '}';
    }

    public void insertPassengers(Passenger passenger) {
        if (seatCounter != passengers.length) {
            if (passenger.getDestination().getPlateNumber() == this.getDestination().getPlateNumber()) {
                passengers[seatCounter] = passenger;
                seatCounter++;
                System.out.println("Passenger inserted !");
            } else {
                System.out.println("Destinations do not match !");
            }
        } else {
            System.out.println("Bus is full !");
        }
    }

}
