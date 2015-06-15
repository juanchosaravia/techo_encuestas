package com.droidcba.techorelevamiento.features.families;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.droidcba.techorelevamiento.R;

import java.util.List;

/**
 * Created by juancho on 6/6/15.
 */
public class FamilyAdapter extends RecyclerView.Adapter<FamilyAdapter.ViewHolder> {

    private List<FamilyItem> family;

    public FamilyAdapter(List<FamilyItem> family) {
        this.family = family;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.family_list_item, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        FamilyItem familyItem = family.get(i);
        viewHolder.tvName.setText(familyItem.getBossFirstName() + " " + familyItem.getBossLastName());
        viewHolder.tvAddress.setText(familyItem.getStreet() + " " + familyItem.getStreetNumber());
        viewHolder.tvPhone.setText("Tel: " + familyItem.getPhone());
    }

    @Override
    public int getItemCount() {
        return family.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvPhone;

        public ViewHolder(View v) {
            super(v);
            tvName = (TextView) v.findViewById(R.id.FamilyItemName);
            tvAddress = (TextView) v.findViewById(R.id.FamilyItemAddress);
            tvPhone = (TextView) v.findViewById(R.id.FamilyItemPhone);
        }
    }
}
