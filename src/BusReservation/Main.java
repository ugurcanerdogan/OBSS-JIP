package BusReservation;

public class Main {


    public static void main(String[] args) {
        Bus bus1 = new Bus(Destination.ANKARA, 2);

        bus1.insertPassengers(new Passenger("Ali", Destination.ANKARA));
        bus1.insertPassengers(new Passenger("Mehmet", Destination.ADANA));
        bus1.insertPassengers(new Passenger("Veli", Destination.ANKARA));
        bus1.insertPassengers(new Passenger("Ahmet", Destination.ANKARA));
        System.out.println("---------------------------");
        System.out.println(bus1);
    }
}
