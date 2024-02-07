# Elevator Simulator
## General Information
### The project is to simulate the behavior of a system designed to optimize the operation of sixteen elevators that can go up and down. The user can interact with the elevators by sending requests from the current floor to another floor.
## Logic
### I assumed that the building has twenty floors divided into zones. Each zone has four elevators.
| Zone | Floors | Color  |
|------|--------|--------|
| 1st  | 0-6    | Green  |
| 2nd  | 7-13   | Yellow |
| 3rd  | 14-20  | Red    |
| 4th  | 0-20   | Blue   |
### The algorithm is based on selecting the elevator which is closest to the receiving floor. In order to optimize, elevators can leave a maximum of two floors from their zone. Blue elevators can go to any floor.



## *ElevatorSystem.java*
### The core class of the elevator system, responsible for managing multiple elevators. It initializes elevators with designated service zones and handles elevator requests. The class provides the logic to find the closest elevator that can service a request within its zone and includes a scheduled method to move the elevators at fixed intervals.
### Key methods:
- `requestElevator(int pickupFloor, int destinationFloor)` : Registers a request for an elevator.
- `status()`: Retrieves the current status of all elevators.
- `performStep()`: Scheduled task that invokes `step()` method periodically.
## *Elevator.java*
### Represents an individual elevator within the system. It contains attributes to track its current floor, service zone, request queue, and occupancy status. It processes pickup requests and moves either towards a target floor based on its current request or continues to move within its service zone if no requests are pending.
### Key methods:
- `addPickupRequest(int pickupFloor, int destinationFloor)`: Adds a new request to the elevator's queue.
- `moveOneStep()`: Moves the elevator one floor towards its current target or within its service zone.
- `getStatus()`: Returns an ElevatorStatus object with the elevator's current floor, destination floor, and occupancy status.
## *ElevatorController.java*
### The REST controller. It provides endpoints to get the status of all elevators, to place a pickup request, and to advance the elevator system by one step.
### Endpoints:
- **GET** `/api/elevators/status`: Returns the current status of all elevators.
- **POST** `/api/elevators/pickup`: Handles a new pickup request.
- **POST** `/api/elevators/step`: Advances the state of the elevator system by one step.
## Used Technologies
- `Java` - the main language used to create the application logic
- `Spring Boot` - the framework used to create the application
- `React.js` - javascript library used to build the user interface
- `Axios` - http client used to communicate with the backend
- `CSS` - user interface styling
## How to run
### To run the application, you need to have `Java` and `Node.js` installed on your machine.
- Clone the repository
- Open the terminal and navigate to the `elevators-app` directory
- Run the following command to start the backend:
```bash
./gradlew bootJar
```
- Run the following command to start the backend:
```bash
java -jar build/libs/elevators-app-0.0.1-SNAPSHOT.jar
````
- Open another terminal and navigate to the `elevators-frontend` directory
- Run the following command to start the frontend:
```bash
npm start
```
- Open your browser and navigate to `http://localhost:3000/` to view the application