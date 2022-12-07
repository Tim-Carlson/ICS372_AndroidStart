package edu.metrostate.cardealer.entity.vehicle;

public class Sedan extends Vehicle {
    private static String vehicleType =  String.valueOf(VehicleType.SEDAN);

    public Sedan() {

    }

    public Vehicle getInstance(String vehicleId) {
        return new Sedan(vehicleId);
    }

    public Sedan(String vehicleId){
        this();
        this.setVehicleId(vehicleId);
    }

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
    public Sedan(String dealershipId, String vehicletype, String vehicleManufacturer, String vehicleModel, String vehicleId, Double price, Long acquisitionDate) {
        super(dealershipId, vehicleType, vehicleManufacturer, vehicleModel, vehicleId, price, acquisitionDate);
    }

//    public Sedan(String vehicleId, String manufacturer, String model, Long acquisitionDate, double price, String dealerId, boolean onLoan) {
//        super(vehicleId, manufacturer, model, acquisitionDate, price, dealerId, onLoan) ;
//    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }
}
