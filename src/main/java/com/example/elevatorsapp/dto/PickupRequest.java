package com.example.elevatorsapp.dto;

public class PickupRequest {
    private int pickupFloor;
    private int destinationFloor;

    public PickupRequest(int pickupFloor, int destinationFloor) {
        this.pickupFloor = pickupFloor;
        this.destinationFloor = destinationFloor;
    }

    public int getPickupFloor() {
        return pickupFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setPickupFloor(int pickupFloor) {
        this.pickupFloor = pickupFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
    @Override
    public String toString() {
        return "PickupRequest{" +
                "pickupFloor=" + pickupFloor +
                ", destinationFloor=" + destinationFloor +
                '}';
    }
}
