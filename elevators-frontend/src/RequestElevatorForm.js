import React, { useState } from 'react';
import './RequestElevatorForm.css';

function RequestElevatorForm({ onRequestElevator }) {
    const [pickupFloor, setPickupFloor] = useState('');
    const [destinationFloor, setDestinationFloor] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        onRequestElevator(pickupFloor, destinationFloor);
    };

    return (
        <form onSubmit={handleSubmit} className="RequestElevatorForm">
            <input
                type="number"
                value={pickupFloor}
                onChange={(e) => setPickupFloor(e.target.value)}
                placeholder="Pickup Floor"
                required
            />
            <input
                type="number"
                value={destinationFloor}
                onChange={(e) => setDestinationFloor(e.target.value)}
                placeholder="Destination Floor"
                required
            />
            <button type="submit">Request Elevator</button>
        </form>
    );
}

export default RequestElevatorForm;
