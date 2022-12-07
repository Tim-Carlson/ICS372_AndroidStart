package edu.metrostate.cardealer.utils;


import org.nd4j.shade.jackson.databind.ObjectMapper;
import org.nd4j.shade.jackson.databind.ObjectWriter;
import org.nd4j.shade.jackson.databind.ser.FilterProvider;
import org.nd4j.shade.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import org.nd4j.shade.jackson.databind.ser.impl.SimpleFilterProvider;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import edu.metrostate.cardealer.entity.vehicle.Vehicle;
import edu.metrostate.cardealer.entity.vehicle.VehicleFactory;

/**
 * A Utility class to read, parse, and write JSON data
 *
 * @see <a href="https://crunchify.com/how-to-read-json-object-from-file-in-java/"></a>
 * <a href="https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/"></a>
 */
public class JSONFileHandler implements IFileHandler {

     static void exportVehicles(List<Vehicle> vehicleList, String dealerId) {
         // create object mapper instance
         ObjectMapper mapper = new ObjectMapper();
         FilterProvider filters = new SimpleFilterProvider()
                 .addFilter("filter properties by name", SimpleBeanPropertyFilter.serializeAllExcept("parsedAcquisitionDate"));

         ObjectWriter writer = mapper.writer(filters);

         try {
             writer.withDefaultPrettyPrinter().writeValue(Paths.get("src/main/resources/vehicle-storage/" + dealerId + "_dealerVehicles.json").toFile(), vehicleList);
         } catch (IOException e) {
             System.out.println("Something went wrong");
             throw new RuntimeException(e);
         }
     }

    @Override
    public <Vehicle> Optional<List<Vehicle>> importDataFromFile(String filePath) {
         List<Vehicle> vehicleList = new ArrayList<>();
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON file to map
            Map<?, ?> map = mapper.readValue(Paths.get(filePath).toFile(), Map.class);
            List<?> car_inventory = (List<?>) map.get("car_inventory");

            System.out.println("User defined car inventory");
            System.out.println(car_inventory);

            var entryCount = 0;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
                entryCount++;
            }
            System.out.println(entryCount);
            //List of vehicles
            for (var obj: car_inventory) {
                var dealerId = obj.toString().split(",")[0].split("=")[1];
                var vehicleType = obj.toString().split(",")[1].split("=")[1];
                var vehicleManufacturer = obj.toString().split(",")[2].split("=")[1];
                var vehicleModel = obj.toString().split(",")[3].split("=")[1];
                var vehicleId = obj.toString().split(",")[4].split("=")[1];
                var acquisitionDate = obj.toString().split(",")[5].split("=")[1];
                var price = obj.toString().split(",")[6].split("=")[1];

                Vehicle v = (Vehicle) VehicleFactory.createVehicle(vehicleType, vehicleId);
                vehicleList.add(v);

                System.out.println(v);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.of(vehicleList);
    }

    @Override
    public <T, U> Collection<U> parse(T data) {
        return null;
    }

    @Override
    public <T> void exportDataToFile(List<T> dataList) {

    }
}

