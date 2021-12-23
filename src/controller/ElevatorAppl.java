package controller;

import model.Elevator;
import model.Truck;

public class ElevatorAppl {
    private static final int N_TRUCKS = 1000;
    private static final int N_RACES = 10;
    private static final int CAPACITY = 20;
    private static final int MAX_ELEVATORS = 2;

    public static void main(String[] args) throws InterruptedException {
        Elevator[] elevators = new Elevator[MAX_ELEVATORS];
        elevators[0] = new Elevator("Lenin");
        elevators[1] = new Elevator("Stalin");
        //elevators[2] = new Elevator("Stalin");
        Truck[] trucks = new Truck[N_TRUCKS];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(N_RACES, CAPACITY, elevators);
        }

        Thread[] threads = new Thread[N_TRUCKS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        for (Elevator elevator : elevators) {
            System.out.println("Elevator " + elevator.getName() + " has " + elevator.getCurrentValue() + " tonn");
        }
    }
}
