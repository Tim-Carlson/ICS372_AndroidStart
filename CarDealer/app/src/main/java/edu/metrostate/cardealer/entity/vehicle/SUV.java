package edu.metrostate.cardealer.entity.vehicle;

public class SUV extends Vehicle {
    private static String vehicleType =  String.valueOf(VehicleType.SUV);

    /** Constructor
     *
     * @param dealershipId dealershipId
     * @param vehicletype vehicle type
     * @param vehicleManufacturer vehicle manufacturer
     * @param vehicleModel vehicle model
     * @param vehicleId vehicle id
     * @param price vehicle price
     * @param acquisitionDate acquisition date
     */
    public SUV(String dealershipId, String vehicletype, String vehicleManufacturer, String vehicleModel, String vehicleId, Double price, Long acquisitionDate) {
        super(dealershipId, vehicleType, vehicleManufacturer, vehicleModel, vehicleId, price, acquisitionDate);
    }


    public SUV() {

    }

    public SUV(String vehicleId){
        this();
        this.setVehicleId(vehicleId);
    }

    public static SUV getInstance(String vehicleId) {
        return new SUV(vehicleId);
    }


    @Override
    public String getVehicleType() {
        return vehicleType;
    }



}
