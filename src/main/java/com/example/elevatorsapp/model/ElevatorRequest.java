package com.example.elevatorsapp.model;

public class ElevatorRequest {
    private final int pickupFloor;
    private final int destinationFloor;
    private boolean pickedUp = false;

    public ElevatorRequest(int pickupFloor, int destinationFloor) {
        this.pickupFloor = pickupFloor;
        this.destinationFloor = destinationFloor;
    }
    public int getPickupFloor() {
        return pickupFloor;
    }
    public int getDestinationFloor() {
        return destinationFloor;
    }
    public boolean hasPickedUp() {
        return pickedUp;
    }
    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }
}
