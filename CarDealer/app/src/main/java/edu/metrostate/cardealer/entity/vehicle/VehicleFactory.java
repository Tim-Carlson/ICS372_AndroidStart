package edu.metrostate.cardealer.entity.vehicle;

public class VehicleFactory {
    /**
     * A simple factory to create a Vehicle subclass of Sedan, SUV, PickUP, or SportsCar based on given vehicle type
     * @params vehicleType
     * @return instance of Vehicle subclass
     */

    public static Vehicle createVehicle(String vehicleType, String vehicleId){
        Vehicle vehicle = null;

        if(vehicleType.equalsIgnoreCase("sedan")){
            vehicle = new Sedan(vehicleId).getInstance(vehicleId);
        }else if (vehicleType.equalsIgnoreCase("suv")){
            vehicle = SUV.getInstance(vehicleId);
        }else if (vehicleType.equalsIgnoreCase("pickup")) {
            vehicle = PickUp.getInstance(vehicleId);
        }else if (vehicleType.equalsIgnoreCase("sports car")) {
            vehicle = SportsCar.getInstance(vehicleId);
        }

        return vehicle;
    }
}
