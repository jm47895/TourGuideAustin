package com.jordanmadrigal.tourguideaustin;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_of_view_groups,container,false);

        final ArrayList<Location> restaurants = new ArrayList<>();

        restaurants.add(new Location(R.drawable.tf_diner, getString(R.string.twentyFourMap), getString(R.string.twentyFourDinerDescription)));
        restaurants.add(new Location(R.drawable.chez_nous, getString(R.string.chezNMap), getString(R.string.chezNousDescription)));
        restaurants.add(new Location(R.drawable.chuys, getString(R.string.chuysMap), getString(R.string.chuysDescription)));
        restaurants.add(new Location(R.drawable.torchies_tacos, getString(R.string.torchiesMap), getString(R.string.torchiesDescription)));
        restaurants.add(new Location(R.drawable.kerbey_lane, getString(R.string.kerbeyMap), getString(R.string.kerbeyLaneDescription)));
        restaurants.add(new Location(R.drawable.chez_zee, getString(R.string.chezZMap), getString(R.string.chezZeeDescription)));
        restaurants.add(new Location(R.drawable.austin_land_and_cattle, getString(R.string.austinLandMap), getString(R.string.austinLandAndCattleDescription)));
        restaurants.add(new Location(R.drawable.barley_swine, getString(R.string.barleyMap),getString(R.string.barleySwineDescription)));
        restaurants.add(new Location(R.drawable.kome, getString(R.string.komeMap), getString(R.string.komeDescription)));
        restaurants.add(new Location(R.drawable.abgb, getString(R.string.abgbMap), getString(R.string.abgbDescription)));
        restaurants.add(new Location(R.drawable.p_terrys, getString(R.string.pTerrysMap), getString(R.string.pTerrysDescription)));


        CardAdapter adapter = new CardAdapter(getActivity(), restaurants);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //Get the individual position of a listView
                Location location = restaurants.get(position);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(location.getUriLocation()));
                startActivity(mapIntent);
            }
        });

        return rootView;
    }

}
