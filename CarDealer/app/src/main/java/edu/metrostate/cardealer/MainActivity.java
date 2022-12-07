package edu.metrostate.cardealer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intents for vehicle list and dealer list activity classes
        Intent vehicleListIntent = new Intent(MainActivity.this, VehicleListActivity.class);
        Intent dealerListIntent = new Intent(MainActivity.this, DealerListActivity.class);

        var vehicleListView = findViewById(R.id.show_vehicle);
        var dealerListView = findViewById(R.id.show_dealer);

        displayView(vehicleListIntent, vehicleListView);
        displayView(dealerListIntent, dealerListView);


    }

    /** A method to start activities based based on intent and view params
     *
     * @param intent
     * @param view
     */
    private void displayView(Intent intent, View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the new Activity
                startActivity(intent);
            }
        });
    }
}