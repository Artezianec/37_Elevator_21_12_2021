package model;

public class Truck implements Runnable {
    private static final Object monitor = new Object();
    private static final Object monitor2 = new Object();
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
        for (int i = 0; i < nRaces; i++) {
            if (hashCode() % 2 == 0) {
                synchronized (monitor) {
                    elevator[0].add((capacity / elevator.length));
                }
                synchronized (monitor2) {
                    elevator[1].add((capacity / elevator.length));
                }
            } else {

                synchronized (monitor) {
                    elevator[1].add((capacity / elevator.length));
                }
                synchronized (monitor2) {
                    elevator[0].add((capacity / elevator.length));
                }
            }
        }
    }
}
