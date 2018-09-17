package com.jordanmadrigal.tourguideaustin;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Create a view with pre-made ListView parameters
        View rootView = inflater.inflate(R.layout.list_of_view_groups,container,false);

        final ArrayList<Location> museums = new ArrayList<>();

        museums.add(new Location(getString(R.string.bobBullock), R.drawable.bullock_exterior, getString(R.string.bobBullockMap), getString(R.string.bobBullockDescription)));
        museums.add(new Location(getString(R.string.blantonArt), R.drawable.blanton_art_museum,getString(R.string.blantonMap), getString(R.string.blantonDescription)));
        museums.add(new Location(getString(R.string.theContemporary), R.drawable.the_contemporary, getString(R.string.contemporaryMap), getString(R.string.contemporaryDescription)));
        museums.add(new Location(getString(R.string.mexicArte), R.drawable.mexic_art_museum, getString(R.string.mexicMap), getString(R.string.mexicDescription)));
        museums.add(new Location(getString(R.string.harryRansom), R.drawable.harry_ransom_center, getString(R.string.harryMap),getString(R.string.harryDescription)));
        museums.add(new Location(getString(R.string.lbjLibrary), R.drawable.lbj_library_and_museum, getString(R.string.lbjMap), getString(R.string.lbjDescription)));
        museums.add(new Location(getString(R.string.thinkery), R.drawable.thinkery, getString(R.string.thinkeryMap), getString(R.string.thinkeryDescription)));
        museums.add(new Location(getString(R.string.elisabetNey), R.drawable.elisabet_ney_museum, getString(R.string.elisabetMap), getString(R.string.elisabetDescription)));

        //new CardAdapter object that will get the activity where this is called (.MainActivity)
        CardAdapter adapter = new CardAdapter(getActivity(), museums);

        //Gives attributes to the rootView ListView created earlier for the @id.list xml
        final ListView listView = rootView.findViewById(R.id.list);

        //Connects new listview with the adapter object
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //Get the individual position of a listView
                Location location = museums.get(position);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(location.getUriLocation()));
                startActivity(mapIntent);
            }
        });

        return rootView;
    }



}
