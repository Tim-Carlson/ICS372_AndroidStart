package edu.metrostate.cardealer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.metrostate.cardealer.entity.vehicle.Vehicle;

public class VehicleAdapter extends ArrayAdapter<Vehicle> {
    public VehicleAdapter(Context context, List<Vehicle> shelterList) {
        super(context, R.layout.vehicle_item, shelterList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.vehicle_item, parent, false);
        }

        TextView acquisitionDate = convertView.findViewById(R.id.acquisition_date);
        TextView makeAndModel = convertView.findViewById(R.id.make_model);
        TextView dealerId = convertView.findViewById(R.id.vehicle_dealer_id);

        acquisitionDate.setText(getItem(position).getAcquisitionDate());
        makeAndModel.setText(String.join(" ", getItem(position).getVehicleManufacturer(), getItem(position).getVehicleModel()));
        dealerId.setText(getItem(position).getDealershipId());

        return convertView;
    }
}
