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
public class OutdoorFragment extends Fragment {


    public OutdoorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_view_groups,container,false);

        final ArrayList<Location> outdoorActivities = new ArrayList<>();

        outdoorActivities.add(new Location(getString(R.string.bartonSprings), R.drawable.barton_springs_pool, getString(R.string.bartonMap), getString(R.string.bartonDescription)));
        outdoorActivities.add(new Location(getString(R.string.zilkerPark), R.drawable.zilker_park, getString(R.string.zilkerMap), getString(R.string.zilkerParkDescription)));
        outdoorActivities.add(new Location(getString(R.string.ladyBirdLake), R.drawable.lady_bird_lake, getString(R.string.ladyBirdMap), getString(R.string.ladyBirdDescription)));
        outdoorActivities.add(new Location(getString(R.string.hamiltonPool), R.drawable.hamilton_pool, getString(R.string.hamiltonPoolMap), getString(R.string.hamiltonPoolDescription)));
        outdoorActivities.add(new Location(getString(R.string.congressBridge), R.drawable.congress_bridge, getString(R.string.congressMap), getString(R.string.congressBridgeDescription)));
        outdoorActivities.add(new Location(getString(R.string.baylorGraffiti), R.drawable.baylor_graffiti, getString(R.string.baylorGraffitiMap), getString(R.string.baylorGraffitiDescription)));
        outdoorActivities.add(new Location(getString(R.string.cathedralJunk), R.drawable.cathedral_of_junk, getString(R.string.cathedralJunk), getString(R.string.cathedralDescription)));
        outdoorActivities.add(new Location(getString(R.string.mountBonell), R.drawable.mount_bonnell, getString(R.string.mountBounellMap), getString(R.string.mountBonnellDescription)));
        outdoorActivities.add(new Location(getString(R.string.threeSixtyBridge), R.drawable.three_sixty_bridge, getString(R.string.threeSixtyBridge), getString(R.string.threeSixtyDescription)));
        outdoorActivities.add(new Location(getString(R.string.outDoorEvents), R.drawable.austin_city_limits, getString(R.string.outdoorEventsDesciption)));

        CardAdapter adapter = new CardAdapter(getActivity(),outdoorActivities);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //Get the individual position of a listView
                Location location = outdoorActivities.get(position);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(location.getUriLocation()));
                startActivity(mapIntent);
            }
        });

        return rootView;
    }

}
