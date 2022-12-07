package edu.metrostate.cardealer.entity;

public class TestVehicle {

    private final String id;
    private final String model;
    private String manufacturer;

    /**
     *
     * @param id
     * @param model
     */
    public TestVehicle(String id, String model){
        this.id = id;
        this.model = model;
        this.manufacturer = "Honda";

    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

}
