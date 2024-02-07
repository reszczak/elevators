package com.example.elevatorsapp.model;

public class ElevatorStatus {
    private final int elevatorId;
    private final int currentFloor;
    private final Integer destinationFloor;
    private final boolean isOccupied;

    public ElevatorStatus(int elevatorId, int currentFloor, Integer destinationFloor, boolean isOccupied) {
        this.elevatorId = elevatorId;
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
        this.isOccupied = isOccupied;
    }
    public int getElevatorId() {
        return elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public Integer getDestinationFloor() {
        return destinationFloor;
    }
    public boolean isOccupied()
    {
        return isOccupied;
    }
}
