package org.example.vehicletypes;

public abstract class Vehicle {
    String licenceNumber;
    VehicleType vehicleType;

    public Vehicle(String licenceNumber, VehicleType vehicleType) {
        this.licenceNumber = licenceNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
