import React, { useState } from 'react';
import './RequestElevatorForm.css';

function RequestElevatorForm({ onRequestElevator }) {
    const [pickupFloor, setPickupFloor] = useState('');
    const [destinationFloor, setDestinationFloor] = useState('');
    const maxFloor = 20;
    const minFloor = 0;

    const handleSubmit = (event) => {
        event.preventDefault();
        const pickup = parseInt(pickupFloor, 10);
        const destination = parseInt(destinationFloor, 10);

        if (pickup >= minFloor && pickup <= maxFloor && destination >= minFloor && destination <= maxFloor) {
            onRequestElevator(pickup, destination);
        } else {
            alert(`Please enter a floor number between ${minFloor} and ${maxFloor}.`);
        }
    };

    return (
        <form onSubmit={handleSubmit} className="RequestElevatorForm">
            <input
                type="number"
                value={pickupFloor}
                onChange={(e) => setPickupFloor(e.target.value)}
                placeholder="Pickup Floor"
                min={minFloor}
                max={maxFloor}
                required
            />
            <input
                type="number"
                value={destinationFloor}
                onChange={(e) => setDestinationFloor(e.target.value)}
                placeholder="Destination Floor"
                min={minFloor}
                max={maxFloor}
                required
            />
            <button type="submit">Request Elevator</button>
        </form>
    );
}

export default RequestElevatorForm;
