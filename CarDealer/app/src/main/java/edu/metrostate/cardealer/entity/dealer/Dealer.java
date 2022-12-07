package edu.metrostate.cardealer.entity.dealer;

import java.util.ArrayList;
import java.util.List;

import edu.metrostate.cardealer.entity.vehicle.Vehicle;

public class Dealer {
    private String dealerId;
    private String name;
    private boolean isAcceptingNewVehicles = true;
    private final List<Vehicle> dealerVehicles =new ArrayList<>();

    public Dealer(){}

    public Dealer(String dealerId) {
        this.dealerId = dealerId;
    }

    public Dealer(String dealerId, String name) {
        this(dealerId);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void enableVehicleAcquisition() {
        this.isAcceptingNewVehicles = true;
    }

    public void disableVehicleAcquisition() {
        isAcceptingNewVehicles = false;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerId() {
        return this.dealerId;
    }

    public boolean acceptingNewVehicles(){
        return isAcceptingNewVehicles;
    }

    public boolean addVehicle(Vehicle vehicle){
        if(!isAcceptingNewVehicles || vehicle == null) return false;

        return dealerVehicles.add(vehicle);
    }

    public List<Vehicle> getDealerVehicles(){
        return List.copyOf(this.dealerVehicles);
    }

    @Override
    public String toString() {
        return "Dealer { " +
                "dealerId:  '" + dealerId + '\'' +
                ", isAcceptingNewVehicles: " + isAcceptingNewVehicles +
                ", name: '" + name + '\'' +
                '}';
    }
}
