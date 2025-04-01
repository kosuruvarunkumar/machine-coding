package org.example;

import org.example.vehicletypes.Vehicle;
import org.example.vehicletypes.VehicleType;

public class ParkingSpot {
    private int spotId;
    private VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotId, VehicleType vehicleType) {
        this.spotId = spotId;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if(isAvailable() && vehicleType.equals(vehicle.getVehicleType())) {
            parkedVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type or spot already taken");
        }
    }

    public void unParkVehicle() {
        parkedVehicle = null;
    }

    public int getSpotId() {
        return spotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
