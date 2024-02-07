import React from 'react';
import './Elevator.css';

function Elevator({ currentFloor, isMoving }) {
    const elevatorStyle = {
        bottom: `${currentFloor * 50}px`,
        transition: 'bottom 1s ease-in-out',
    };

    const elevatorClass = `Elevator ${isMoving ? 'active' : ''}`;

    return (
        <div className={elevatorClass} style={elevatorStyle} />
    );
}

export default Elevator;
