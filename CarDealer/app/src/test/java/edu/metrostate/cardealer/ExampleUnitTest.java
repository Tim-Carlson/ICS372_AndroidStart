package edu.metrostate.cardealer;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.metrostate.cardealer.entity.TestVehicle;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testVehicleShowsManufacturer(){
        TestVehicle v = new TestVehicle("testV", "Accord");

        v.setManufacturer("Honda");

//        assert
        String expected = "Honda";
        String result = v.getManufacturer();

        assertEquals(result, expected);
    }
}