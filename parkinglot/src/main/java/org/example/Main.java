package org.example;

import org.example.vehicletypes.Car;
import org.example.vehicletypes.MotorCycle;
import org.example.vehicletypes.Truck;
import org.example.vehicletypes.Vehicle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addFloor(new Floor(1, 10));
        parkingLot.addFloor(new Floor(2, 20));

        parkingLot.showAvailability();

        Vehicle car = new Car("PB12AS1234");
        Vehicle truck = new Truck("KA12AS1234");
        Vehicle motorCycle = new MotorCycle("AR12AS1234");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorCycle);

        parkingLot.showAvailability();

        parkingLot.unParkVehicle(truck);
        parkingLot.unParkVehicle(motorCycle);

        parkingLot.showAvailability();
    }
}