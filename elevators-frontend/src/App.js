import React, { useState, useEffect } from 'react';
import axios from 'axios';
import ElevatorShaft from './ElevatorShaft';
import RequestElevatorForm from './RequestElevatorForm';
import './App.css';

function App() {
  const [elevators, setElevators] = useState([]);
  const [error, setError] = useState('');

  const fetchElevatorStatus = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/elevators/status');
      setElevators(response.data);
      setError('');
    } catch (error) {
      setError('Error fetching elevator status');
      console.error('Problem z pobraniem statusu windy:', error);
    }
  };


  useEffect(() => {
    fetchElevatorStatus();
    const intervalId = setInterval(fetchElevatorStatus, 1000);


    return () => clearInterval(intervalId);
  }, []);

  const handleRequestElevator = async (pickupFloor, destinationFloor) => {
    try {
      await axios.post('http://localhost:8080/api/elevators/pickup', { pickupFloor, destinationFloor });
      fetchElevatorStatus();
    } catch (error) {
      setError('Error sending pickup request');
      console.error('Problem z wysłaniem żądania o windę:', error);
    }
  };


  return (
      <div className="App">
        <h1>Elevator System</h1>
        {error && <p className="Error">{error}</p>}
        <RequestElevatorForm onRequestElevator={handleRequestElevator} />
        <div className="ElevatorShaftContainer">
          {elevators.map((elevator, index) => (
              <ElevatorShaft key={index} elevator={elevator} />
          ))}
        </div>
      </div>
  );
}

export default App;
