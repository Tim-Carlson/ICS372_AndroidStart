package edu.metrostate.cardealer.entity.vehicle;

public class SportsCar extends Vehicle {
    private static String vehicleType =  String.valueOf(VehicleType.SPORTS_CAR);

    public static SportsCar getInstance(String vehicleId) {
        return new SportsCar(vehicleId);
    }

    public SportsCar(){
    }

    public SportsCar(String vehicleId){
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
    public SportsCar(String dealershipId, String vehicletype, String vehicleManufacturer, String vehicleModel, String vehicleId, Double price, Long acquisitionDate) {
        super(dealershipId, vehicleType, vehicleManufacturer, vehicleModel, vehicleId, price, acquisitionDate);
    }

//    public SportsCar(String vehicleId, String manufacturer, String model, Long acquisitionDate, double price, String dealerId, boolean onLoan) {
//        super(vehicleId, manufacturer, model, acquisitionDate, price, dealerId, onLoan) ;
//    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }
}
