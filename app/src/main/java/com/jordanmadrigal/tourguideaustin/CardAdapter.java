package com.jordanmadrigal.tourguideaustin;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Recycle view adapter of location cards listed
 */

public class CardAdapter extends ArrayAdapter<Location>{

    public CardAdapter(Activity context, ArrayList<Location> place){
        super(context, 0, place);
    }

    @Override
    //Inflate a view group if not present
    public View getView(int position, View convertView, ViewGroup parent) {
        View cardView = convertView;
        if(cardView == null) {
            cardView = LayoutInflater.from(getContext()).inflate(R.layout.view_group_items, parent, false);
        }
            Location currentCard = getItem(position);

            ImageView locationImg = cardView.findViewById(R.id.cardImage);
            if(currentCard.hasImage()){
                locationImg.setImageResource(currentCard.getImgResId());
                locationImg.setVisibility(View.VISIBLE);
            }else{
                locationImg.setVisibility(View.GONE);
            }

            TextView locationTitle = cardView.findViewById(R.id.cardText);
            locationTitle.setText(currentCard.getLocation());

            TextView locationDescription = cardView.findViewById(R.id.cardDescription);
            locationDescription.setText(currentCard.getDescription());

            

            return cardView;
    }
}
