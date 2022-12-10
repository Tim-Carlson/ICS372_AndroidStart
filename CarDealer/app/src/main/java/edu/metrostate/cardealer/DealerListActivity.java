package edu.metrostate.cardealer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import edu.metrostate.cardealer.entity.dealer.Dealer;

public class DealerListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_list);

        // Get the application instance from the activity
        CarDealerApplication app = (CarDealerApplication) getApplication();

        // Create an adapter for the list view
        DealerAdapter adapter = new DealerAdapter(this, app.getDealerList());

        // Find the list view and add the adapter
        ListView dealerList = findViewById(R.id.dealer_list);
        dealerList.setAdapter(adapter);

        dealerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDialog(adapter.getItem(position));
            }
        });

    }

    private void showDialog(Dealer dealer) {

        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("My alert2")
                .setCancelable(false)
                .setTitle("Dealer ID: " + dealer.getDealerId())
                .setMessage(dealer.toString())
                .setPositiveButton( "OK", (dialog1, id) -> dialog1.dismiss()).create();

        dialog.show();



    }
}