package com.example.elevatorsapp.model;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {
    private final int id;
    private int currentFloor;
    private final Queue<ElevatorRequest> requests;
    private ElevatorRequest currentRequest;
    private int serviceZoneStart;
    private int serviceZoneEnd;
    private boolean isGlobal;
    private boolean movingUp = true;
    private boolean isOccupied = false;


    public Elevator(int id, int serviceZoneStart, int serviceZoneEnd, int startingFloor, boolean isGlobal) {
        this.id = id;
        this.currentFloor = startingFloor;
        this.serviceZoneStart = serviceZoneStart;
        this.serviceZoneEnd = serviceZoneEnd;
        this.isGlobal = isGlobal;
        this.requests = new PriorityQueue<>(Comparator.comparingInt(req -> req.getPickupFloor()));
        this.currentRequest = null;
    }

    public void addPickupRequest(int pickupFloor, int destinationFloor) {
        requests.offer(new ElevatorRequest(pickupFloor, destinationFloor));
        isOccupied = true;
    }

    public boolean isWithinServiceZone(int floor) {
        if (isGlobal) {
            return true;
        }
        return (floor >= serviceZoneStart && floor <= serviceZoneEnd) ||
                (floor >= serviceZoneStart - 2 && floor <= serviceZoneEnd + 2);
    }

    public void moveOneStep() {
        if (currentRequest != null) {
            int targetFloor = currentRequest.hasPickedUp() ? currentRequest.getDestinationFloor() : currentRequest.getPickupFloor();
            if (currentFloor < targetFloor) {
                currentFloor++;
            } else if (currentFloor > targetFloor) {
                currentFloor--;
            }
            if (currentFloor == targetFloor) {
                if (!currentRequest.hasPickedUp()) {
                    currentRequest.setPickedUp(true);
                } else {
                    currentRequest = null;
                    isOccupied = false;
                }
            }
        } else if (!requests.isEmpty()) {
            currentRequest = requests.poll();
            isOccupied = true;
        }
    }

    public ElevatorStatus getStatus() {
        Integer destinationFloor = null;
        if (currentRequest != null) {
            destinationFloor = currentRequest.getDestinationFloor();
        } else if (!requests.isEmpty() && requests.peek() != null) {
            destinationFloor = requests.peek().getDestinationFloor();
        }

        return new ElevatorStatus(id, currentFloor, destinationFloor, isOccupied());
    }
    public int getId() {
        return this.id;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

}
