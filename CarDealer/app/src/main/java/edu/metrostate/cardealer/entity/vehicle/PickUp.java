package edu.metrostate.cardealer.entity.vehicle;

public class PickUp extends Vehicle {
    private static String vehicleType =  String.valueOf(VehicleType.PICK_UP);

    public PickUp() {

    }

    public static PickUp getInstance(String vehicleId) {
        return new PickUp(vehicleId);
    }

    public PickUp(String vehicleId){
        this();
        this.setVehicleId(vehicleId);
    }

    /**
     *
     * @param dealershipId dealershipId
     * @param vehicletype vehicle type
     * @param vehicleManufacturer vehicle manufacturer
     * @param vehicleModel vehicle model
     * @param vehicleId vehicle id
     * @param price vehicle price
     * @param acquisitionDate acquisition date
     */
    public PickUp(String dealershipId, String vehicletype, String vehicleManufacturer, String vehicleModel, String vehicleId, Double price, Long acquisitionDate) {
        super(dealershipId, vehicleType, vehicleManufacturer, vehicleModel, vehicleId, price, acquisitionDate);

    }
//
//    public PickUp(String vehicleId, String manufacturer, String model, Long acquisitionDate, double price, String dealerId, boolean onLoan) {
//        super(vehicleId, manufacturer, model, acquisitionDate, price, dealerId) ;
//    }



    @Override
    public String getVehicleType() {
        return vehicleType;
    }
}
