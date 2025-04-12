import React, { useEffect, useState } from "react";
import axios from "axios";
import CattleAlert from "./components/CattleAlert";
import "./App.css";

function App() {
  const [alerts, setAlerts] = useState([]);
  const [resetSignal, setResetSignal] = useState(false);

  // Fetch alerts from backend
  const fetchAlerts = async () => {
    try {
      const response = await axios.get("http://localhost:8080/alerts");
      setAlerts(response.data);
    } catch (error) {
      console.error("Failed to fetch alerts:", error);
    }
  };

  // Clear/reset alerts from backend
  const clearAlerts = async () => {
    try {
      await axios.delete("http://localhost:8080/alerts/clear");
      setResetSignal((prev) => !prev); // Toggle signal to notify children
      fetchAlerts(); // Optionally refresh data
    } catch (error) {
      console.error("Failed to clear alerts:", error);
    }
  };

  useEffect(() => {
    fetchAlerts(); // Initial fetch
    const interval = setInterval(fetchAlerts, 5000); // Poll every 5 seconds
    return () => clearInterval(interval); // Cleanup
  }, []);

  return (
    <div className="container">
      <div className="alert-box">
        <button className="clear-button" onClick={clearAlerts}>
          <span>CLEAR</span>
        </button>

        <div className="alert-list">
          {alerts.map((alert) => (
            <CattleAlert
              key={alert.id}
              id={alert.id}
              sensingHours={alert.sensingHours}
              restingHours={alert.restingHours}
              resetSignal={resetSignal}
            />
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;