package com.example.elevatorsapp.controller;

import com.example.elevatorsapp.dto.PickupRequest;
import com.example.elevatorsapp.model.ElevatorSystem;
import com.example.elevatorsapp.model.ElevatorStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elevators")
public class ElevatorController {

    private final ElevatorSystem elevatorSystem;

    @Autowired
    public ElevatorController(ElevatorSystem elevatorSystem) {
        this.elevatorSystem = elevatorSystem;
    }

    @GetMapping("/status")
    public ResponseEntity<List<ElevatorStatus>> getStatus() {
        List<ElevatorStatus> status = elevatorSystem.status();
        return ResponseEntity.ok(status);
    }

    @PostMapping("/pickup")
    public ResponseEntity<?> requestPickup(@RequestBody PickupRequest pickupRequest) {
        elevatorSystem.requestElevator(pickupRequest.getPickupFloor(), pickupRequest.getDestinationFloor());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/step")
    public ResponseEntity<?> step() {
        elevatorSystem.step();
        return ResponseEntity.ok().build();
    }
}
