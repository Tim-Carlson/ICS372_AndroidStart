package edu.metrostate.cardealer.entity.vehicle;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SUVTest{
    Vehicle vehicle;

    @BeforeEach
    public void setUp() {
        vehicle = new SUV("dealer001", "suv", "Honda", "Accord", "v001", 34500.05, 1670102205108L);
    }


    @Test
    public void returnsSUVType(){
        String expectedType = "suv";
        assertEquals(expectedType, vehicle.getVehicleType().toLowerCase());
    }
}