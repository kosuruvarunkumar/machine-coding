package org.example;

import org.example.vehicletypes.Vehicle;
import org.example.vehicletypes.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;

    public Floor(int floorNumber, int totalSpots) {
        this.floorNumber = floorNumber;
        parkingSpots = new ArrayList<>();
        double carSpots = 0.4;
        double motorCycleSpots = 0.4;

        int totalCars = (int)(carSpots * totalSpots);
        int totalMotorCycles = (int)(motorCycleSpots * totalSpots);

        for(int idx=0;idx<totalCars;idx++) {
            parkingSpots.add(new ParkingSpot(idx+1, VehicleType.CAR));
        }

        for(int idx=totalCars; idx < totalCars+totalMotorCycles; idx++) {
            parkingSpots.add(new ParkingSpot(idx+1, VehicleType.MOTORCYCLE));
        }

        for(int idx=totalCars + totalMotorCycles;idx<totalSpots;idx++) {
            parkingSpots.add(new ParkingSpot(idx+1, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.isAvailable() && vehicle.getVehicleType().equals(spot.getVehicleType())) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots) {
            if(!spot.isAvailable() && vehicle.equals(spot.getParkedVehicle())) {
                spot.unParkVehicle();
                return true;
            }
        }
        return false;
    }

    public void showAvailability() {
        System.out.println("Floor : " + floorNumber + " availability:");
        for(ParkingSpot spot : parkingSpots) {
            System.out.println("Spot Id: "+ spot.getSpotId() + " Vehicle type: " + spot.getVehicleType() + " Available ? " + (spot.isAvailable()?" Yes" : " No"));
        }
    }
}
