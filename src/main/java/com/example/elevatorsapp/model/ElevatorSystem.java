    package com.example.elevatorsapp.model;

    import org.springframework.stereotype.Service;
    import org.springframework.scheduling.annotation.Scheduled;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.stream.Collectors;
    import java.util.Comparator;
    import java.util.Random;

    @Service
    public class ElevatorSystem {
        private final List<Elevator> elevators;
        Random random = new Random();

        public ElevatorSystem() {
            elevators = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                elevators.add(new Elevator(i, 0, 6, random.nextInt(7), false));
            }

            for (int i = 4; i < 8; i++) {
                elevators.add(new Elevator(i, 7, 13, random.nextInt(6)+7,false));
            }

            for (int i = 8; i < 12; i++) {
                elevators.add(new Elevator(i, 14, 20, random.nextInt(6)+14,false));
            }

            for (int i = 12; i < 16; i++) {
                elevators.add(new Elevator(i, 0, 20, random.nextInt(21), true));
            }
        }

        public void requestElevator(int pickupFloor, int destinationFloor) {
            Elevator closestElevator = elevators.stream()
                    .filter(elevator -> !elevator.isOccupied() && elevator.isWithinServiceZone(pickupFloor) && elevator.isWithinServiceZone(destinationFloor))
                    .min(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor() - pickupFloor)))
                    .orElse(null);

            if (closestElevator == null) {
                closestElevator = elevators.stream()
                        .filter(Elevator::isGlobal)
                        .min(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor() - pickupFloor)))
                        .orElseThrow(() -> new IllegalStateException("No available elevators for the requested floor."));
            }

            closestElevator.addPickupRequest(pickupFloor, destinationFloor);
        }

        private Elevator findClosestElevator(int pickupFloor) {
            return elevators.stream()
                    .min((e1, e2) -> Integer.compare(
                            Math.abs(e1.getCurrentFloor() - pickupFloor),
                            Math.abs(e2.getCurrentFloor() - pickupFloor)))
                    .orElseThrow(() -> new IllegalStateException("No elevators available"));
        }

        public void step() {
            elevators.forEach(Elevator::moveOneStep);
        }

        public List<ElevatorStatus> status() {
            return elevators.stream()
                    .map(elevator -> elevator.getStatus())
                    .collect(Collectors.toList());
        }
        public List<Elevator> getElevators() {
            return this.elevators;
        }

        @Scheduled(fixedRate = 1000)
        public void performStep() {
            for (Elevator elevator : elevators) {
                elevator.moveOneStep();
            }
}
    }
