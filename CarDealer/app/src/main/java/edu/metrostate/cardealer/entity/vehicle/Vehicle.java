package edu.metrostate.cardealer.entity.vehicle;

import org.nd4j.shade.jackson.annotation.JsonIgnore;
import org.nd4j.shade.jackson.annotation.JsonSubTypes;
import org.nd4j.shade.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "vehicle_type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Sedan.class, name = "sedan"),
            @JsonSubTypes.Type(value = PickUp.class, name = "pickup"),
            @JsonSubTypes.Type(value = SUV.class, name = "suv"),
            @JsonSubTypes.Type(value = SportsCar.class, name = "sports car")
    })
public abstract class Vehicle {
    public enum VehicleType {SEDAN, SUV, SPORTS_CAR, PICK_UP}

    private String dealershipId;
    private String vehicleType;
    private String vehicleManufacturer;
    private String vehicleModel;
    private String vehicleId;
    private BigDecimal price;
    private Long acquisitionDate;
    @JsonIgnore private boolean isOnLoan = false;

    public Vehicle(){

    }
    /**Constructor
     *
     * @param dealershipId the dealerId
     * @param vehicleType the vehicle type: SUV, PickUP, SportsCar, Sedan
     * @param vehicleManufacturer the vehicleManufacturer
     * @param vehicleModel the vehicleModel
     * @param vehicleId the vehicle id
     * @param price the vehicle price
     * @param acquisitionDate the vehicle acquisition date in epochMill
//     * @param isOnLoan boolean true or false
     */
//    public Vehicle(String dealershipId, String vehicleType, String vehicleManufacturer, String vehicleModel, String vehicleId, Double price, Long acquisitionDate) {
//        this(dealershipId, vehicleType, vehicleManufacturer, vehicleModel, vehicleId, price, acquisitionDate);
//        this.isOnLoan = isOnLoan;
//    }

    public Vehicle(String dealershipId, String vehicleType, String vehicleManufacturer, String vehicleModel, String vehicleId, Double price, Long acquisitionDate) {
        this.dealershipId = dealershipId;
        this.vehicleType = vehicleType;
        this.vehicleManufacturer = vehicleManufacturer;
        this.vehicleModel = vehicleModel;
        this.vehicleId = vehicleId;
        this.setPrice(price);
        this.acquisitionDate = acquisitionDate;
        this.isOnLoan = false;
    }


    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleManufacturer() {
        return vehicleManufacturer;
    }

    public void setVehicleManufacturer(String vehicleManufacturer) {
        this.vehicleManufacturer = vehicleManufacturer;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    /**
     *
     * @return a parse string date value
     */
    public String getAcquisitionDate(){
        return parseEpochMilliDate(acquisitionDate).toLocalDate().toString();
    }

    /**
     *
     * @param epochDate the epochDate
     * @return parsed date from epochDate
     */
    private ZonedDateTime parseEpochMilliDate(Long epochDate) {
        Instant parsedDateInstant = Instant.ofEpochMilli(epochDate);
        return parsedDateInstant.atZone(ZoneId.of("America/Chicago"));
    }

    public void setAcquisitionDate(Long acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public double getPrice() {
        return price.doubleValue();
    }

    public void setPrice(Double price) {
        this.price = BigDecimal.valueOf(price);
    }

    public abstract String getVehicleType();

        public void setDealershipId(String newDealerId){
        dealershipId = newDealerId;
    }

    public String getDealershipId(){
        return this.dealershipId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return getVehicleId().equals(vehicle.getVehicleId()) && Objects.equals(getVehicleManufacturer(), vehicle.getVehicleManufacturer()) && Objects.equals(getVehicleModel(), vehicle.getVehicleModel()) && Objects.equals(getAcquisitionDate(), vehicle.getAcquisitionDate()) && Objects.equals(getVehicleType(), vehicle.getVehicleType());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleManufacturer='" + vehicleManufacturer + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", acquisitionDate=" + acquisitionDate +
                ", price=" + price +
                ", vehicleType=" + getVehicleType() +
                ", dealerId=" + dealershipId +
                '}';
    }

    /**
     *
     * @return true if vehicle is onLoan
     */
    boolean isVehicleOnLoan(){
        return isOnLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.isOnLoan = onLoan;
    }

}
