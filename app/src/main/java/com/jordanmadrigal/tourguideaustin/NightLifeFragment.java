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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NightLifeFragment extends Fragment {


    public NightLifeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.list_of_view_groups, container, false);

        final ArrayList<Location> nightLife = new ArrayList();

        nightLife.add(new Location(getString(R.string.sixthStreet), R.drawable.dirty_sixth, getString(R.string.sixthMap), getString(R.string.sixthDescription)));
        nightLife.add(new Location(getString(R.string.domain), R.drawable.the_domain, getString(R.string.domainMap), getString(R.string.domainDescription)));
        nightLife.add(new Location(getString(R.string.brokenSpoke), R.drawable.broken_spoke, getString(R.string.brokenSpokeMap), getString(R.string.brokenSpokeDescription)));
        nightLife.add(new Location(getString(R.string.danceAcrossTexas), R.drawable.dance_across_texas, getString(R.string.danceAcrossTexas), getString(R.string.danceAcrossDescription)));
        nightLife.add(new Location(getString(R.string.womensFed), R.drawable.the_fed_swing, getString(R.string.womensMap), getString(R.string.womensFdDescription)));
        nightLife.add(new Location(getString(R.string.inspiredMovement), R.drawable.inspired_movement, getString(R.string.inspiredMap), getString(R.string.inspiredDescription)));
        nightLife.add(new Location(getString(R.string.capcityComedy), R.drawable.cap_city_comedy, getString(R.string.capCityMap), getString(R.string.capCityDescription)));
        nightLife.add(new Location(getString(R.string.raineyStreet), R.drawable.rainey_street, getString(R.string.raineyMap), getString(R.string.raineyDescription)));
        nightLife.add(new Location(getString(R.string.longCenter), R.drawable.long_center, getString(R.string.longMap), getString(R.string.longCenterDescription)));


        CardAdapter adapter = new CardAdapter(getActivity(), nightLife);

        ListView listView = rootview.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //Get the individual position of a listView
                Location location = nightLife.get(position);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(location.getUriLocation()));
                startActivity(mapIntent);
            }
        });

        return rootview;
    }

}
