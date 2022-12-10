package edu.metrostate.cardealer;

import android.app.Application;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import edu.metrostate.cardealer.entity.dealer.Dealer;
import edu.metrostate.cardealer.entity.vehicle.Vehicle;
import edu.metrostate.cardealer.entity.vehicle.VehicleFactory;

public class CarDealerApplication extends Application {
    private final List<Vehicle> vehicleList = new ArrayList<>();
    private final List<Dealer> dealerList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();


        //TODO: Remove this code
        for(int i = 0; i < 20; i++) {
            Vehicle vehicle = VehicleFactory.createVehicle("sedan", Integer.toString(i));
            vehicle.setVehicleModel("Accord");
            vehicle.setVehicleManufacturer("Honda");
            vehicle.setDealershipId("dealer" +(i%3)); //to generate 3 unique dealers
            vehicle.setAcquisitionDate(1515354694451L);

            vehicleList.add(vehicle);
        }

        Dealer d1 = new Dealer("001", "Dealer1");
        Dealer d2 = new Dealer("002", "Dealer2");
        Dealer d3 = new Dealer("003", "Dealer3");
        Dealer d4 = new Dealer("004", "Dealer4");
        dealerList.add(d1);
        dealerList.add(d2);
        dealerList.add(d3);
        dealerList.add(d4);

    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public List<Dealer> getDealerList() {return dealerList;}

    public void writeFile() {

        //TODO: Remove this code
        // Gets the output path which is /sdcard/Android/data/edu.metrostate.cardealer/files directory
        File externalDir = getExternalFilesDir(null);

        // Establishes the output file as "myfile.txt"
        File outputFile = new File(externalDir, "myfile.txt");

        try {
            Files.createFile(outputFile.toPath());

            // Saves the string "My data" to the file
            Files.write(outputFile.toPath(), "My data".getBytes());

        } catch (IOException ex) {
            Log.e("FileCreation", "Error creating file", ex);
        }

    }



}
