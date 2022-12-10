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

import edu.metrostate.cardealer.entity.dealer.Dealer;

public class DealerAdapter extends ArrayAdapter<Dealer> {
    public DealerAdapter(Context context, List<Dealer> shelterList) {
        super(context, R.layout.dealer_item, shelterList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dealer_item, parent, false);
        }

        TextView dealerId = convertView.findViewById(R.id.dealer_id);
        TextView dealerName = convertView.findViewById(R.id.dealer_name);

        dealerId.setText(getItem(position).getDealerId());
        dealerName.setText(getItem(position).getName());

        return convertView;
    }
}
