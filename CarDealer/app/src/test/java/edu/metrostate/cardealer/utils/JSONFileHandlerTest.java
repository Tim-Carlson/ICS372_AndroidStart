package edu.metrostate.cardealer.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JSONFileHandlerTest {
    String jsonTestDataFilePath = "C:\\Users\\msjal\\source\\repos\\ics372\\testAndroid\\ICS372_AndroidStart\\CarDealer\\app\\src\\main\\java\\edu\\metrostate\\cardealer\\data\\test_json_vehicle_inventory_data.json";
    IFileHandler fileHandler;
    @BeforeEach
    void setUp() {
        fileHandler = new JSONFileHandler();
    }

    @Test
    void importDataFromFile() {
        fileHandler.importDataFromFile(jsonTestDataFilePath);


    }

    @Test
    void parse() {
    }

    @Test
    void exportDataToFile() {
    }
}