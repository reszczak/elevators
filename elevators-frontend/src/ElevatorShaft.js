import React from 'react';
import './ElevatorShaft.css';

const floorHeight = 50;

function ElevatorShaft({ elevator }) {
    const elevatorBottomPosition = elevator.currentFloor * floorHeight;
    const { elevatorId, currentFloor } = elevator;

    const floors = [];
    for (let i = 20; i >= 0; i--) {
        let floorStyle = {};
        if (i >= 0 && i <= 6) {
            floorStyle.backgroundColor = 'rgba(144, 238, 144, 0.5)';
        } else if (i >= 7 && i <= 13) {
            floorStyle.backgroundColor = 'rgba(255, 255, 224, 0.5)';
        } else if (i >= 14 && i <= 20) {
            floorStyle.backgroundColor = 'rgba(255, 99, 71, 0.5)';
        }

        floors.push(
            <div className="Floor" key={i} style={floorStyle}>
                {i}
            </div>
        );
    }
    const getElevatorClass = (id) => {
        if (id >= 0 && id <= 3) return 'green-elevator';
        if (id >= 4 && id <= 7) return 'yellow-elevator';
        if (id >= 8 && id <= 11) return 'red-elevator';
        if (id >= 12 && id <= 15) return 'blue-elevator';
    };

    const elevatorClass = getElevatorClass(elevatorId);


    const elevatorStyle = {
        bottom: `${elevatorBottomPosition}px`,
        transition: 'bottom 1s ease-in-out',
    };

    return (
        <div className="ElevatorShaft">
            {floors}

            <div className={`Elevator ${elevatorClass}`} style={elevatorStyle}/>
        </div>
    );
}

export default ElevatorShaft;
