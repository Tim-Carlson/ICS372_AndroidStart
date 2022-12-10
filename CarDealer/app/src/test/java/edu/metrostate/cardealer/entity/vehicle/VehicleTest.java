package edu.metrostate.cardealer.entity.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Logger;


class VehicleTest {

    static Logger LOGGER = Logger.getLogger(VehicleTest.class.getName());
    Vehicle testVehicle;

    @BeforeEach
    void setUp() {
        String vehicleType = "seDAN";
        String vehicleId = "v0001";
        testVehicle = VehicleFactory.createVehicle(vehicleType, vehicleId);
        testVehicle.setVehicleManufacturer("Honda");
        testVehicle.setVehicleModel("Accord");
        testVehicle.setAcquisitionDate(1515354694451L);
        testVehicle.setPrice(20123.0);
        LOGGER.info(testVehicle.toString());
    }




    @Test
    void getAcquisitionDateReturnsExpectedDate() {
        Long input = 1663379660000L;
        System.out.println(testVehicle.getAcquisitionDate());
        testVehicle.setAcquisitionDate(input);

        String expected = LocalDate.of(2022, Month.SEPTEMBER, 16).toString();
        String result = testVehicle.getAcquisitionDate();

       assertEquals(result, expected);
    }

}