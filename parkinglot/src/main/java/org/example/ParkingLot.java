package org.example;

import org.example.vehicletypes.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot parkingLot;
    private List<Floor> floors;

    private ParkingLot() {
        floors = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if(parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for(Floor floor : floors) {
            if(floor.parkVehicle(vehicle)) {
                System.out.println("Vehicle parked Successfully");
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for(Floor floor : floors) {
            if(floor.unParkVehicle(vehicle)) {
                System.out.println("Vehicle unParked Successfully");
                return true;
            }
        }
        return false;
    }

    public void showAvailability() {
        for(Floor floor : floors) {
            floor.showAvailability();
        }
    }
}
