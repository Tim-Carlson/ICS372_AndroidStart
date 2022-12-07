package edu.metrostate.cardealer.entity.dealer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.metrostate.cardealer.entity.vehicle.Vehicle;
import edu.metrostate.cardealer.entity.vehicle.VehicleFactory;

class DealerTest {
    Dealer dealer1, dealer2;
    Vehicle v1, v2;

    @BeforeEach
    void setUp() {
        dealer1 = new Dealer("d001", "Dealer1");

        v1 = VehicleFactory.createVehicle("suv", "v001");
        v1.setVehicleManufacturer("Toyota");
        v1.setVehicleModel("Tundra");

        v2 = VehicleFactory.createVehicle("sedan", "v002");
        v2.setVehicleManufacturer("Honda");
        v2.setVehicleModel("Accord");
    }

    @Test
    void canAddNewVehicleIfDealerAcceptingVehicles() {
        dealer1.enableVehicleAcquisition();
        assertTrue(dealer1.addVehicle(v1));
    }

    @Test
    void cannotAddVehiclesIfDealerNotAcceptingVehicles() {
        //act
        dealer1.addVehicle(v1);
        dealer1.disableVehicleAcquisition();

        var result = dealer1.addVehicle(v2);
        var actualVehicleCount = dealer1.getDealerVehicles().size();
        var expectedVehicleCount = 1;
        assertEquals(false, result);
        assertEquals(expectedVehicleCount, actualVehicleCount);

    }

}