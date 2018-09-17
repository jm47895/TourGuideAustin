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
public class EventFragment extends Fragment {


    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_view_groups, container, false);

        final ArrayList<Location> events = new ArrayList();

        events.add(new Location(getString(R.string.leGarageSale), R.drawable.le_garage, getString(R.string.leGarageWebsite), getString(R.string.leGarageDescription)));
        events.add(new Location(getString(R.string.austinMarathon), R.drawable.austin_marathon, getString(R.string.austinMarathonWebsite), getString(R.string.austinMarathonDescription)));
        events.add(new Location(getString(R.string.sxsw), R.drawable.sxsw_austin, getString(R.string.sxswWebsite), getString(R.string.sxswDescription)));
        events.add(new Location(getString(R.string.moonTower), R.drawable.moon_tower_festival, getString(R.string.moonTowerWebsite), getString(R.string.moonTowerDescription)));
        events.add(new Location(getString(R.string.pecanStreetFestival), R.drawable.pecan_street_festival, getString(R.string.pecanStreetWebsite), getString(R.string.pecanStreetDescription)));
        events.add(new Location(getString(R.string.republicOfTexasBikerRally), R.drawable.biker_rally, getString(R.string.rotWebsite), getString(R.string.rotDescription)));
        events.add(new Location(getString(R.string.fourthOfJuly), R.drawable.austin_indepedence_day, getString(R.string.fourthOfJulyWebsite), getString(R.string.fourthOfJulyDescription)));
        events.add(new Location(getString(R.string.hotSauceFestival), R.drawable.austin_hot_sauce, getString(R.string.hotSauceWebsite), getString(R.string.hotSauceDescription)));
        events.add(new Location(getString(R.string.austinMuseum), R.drawable.austin_museum_day, getString(R.string.austinMuseumWebsite), getString(R.string.austinMuseumDescription)));
        events.add(new Location(getString(R.string.austinCityLimits), R.drawable.acl_fest, getString(R.string.aclWebsite), getString(R.string.aclDescription)));
        events.add(new Location(getString(R.string.funFunFun), R.drawable.fun_fun_fun, getString(R.string.funFunWebsite), getString(R.string.funFunDescription)));
        events.add(new Location(getString(R.string.trailLights), R.drawable.trail_of_lights, getString(R.string.trailOfLightsWebsite), getString(R.string.trailOfLightsDescription)));

        CardAdapter adapter = new CardAdapter(getActivity(), events);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Location location = events.get(position);

                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(location.getUriLocation()));
                startActivity(webIntent);

            }
        });

        return rootView;
    }

}
