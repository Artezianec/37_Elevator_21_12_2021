package model;

public class Truck implements Runnable {
    private static final Object monitor = new Object();
    int nRaces;
    int capacity;
    Elevator[] elevator;

    public Truck(int nRaces, int capacity, Elevator[] elevator) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for (Elevator value : elevator) {
            synchronized (monitor) {
                value.add((capacity / elevator.length));
            }
        }
    }

}
