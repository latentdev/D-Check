package com.latentdev.d_check;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.latentdev.d_check.Fragments.CaliforniaAdventureFragment;
import com.latentdev.d_check.Fragments.DisneylandFragment;
import com.latentdev.d_check.Fragments.SettingsFragment;
import com.latentdev.d_check.Model.Rides;


public class MainActivity extends FragmentActivity implements DisneylandFragment.OnFragmentInteractionListener,SettingsFragment.OnFragmentInteractionListener, CaliforniaAdventureFragment.OnFragmentInteractionListener{

    Rides model;

    Fragment disneyland;
    Fragment californiaAdventure;
    Fragment settings;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment, disneyland)
                            .commit();
                    return true;
                }
                case R.id.navigation_dashboard: {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment, californiaAdventure)
                            .commit();
                    return true;
                }
                case R.id.navigation_notifications: {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment,settings)
                            .commit();
                    return true;
                }
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getTitle());


        model = new Rides();
        model.Start();

        disneyland = DisneylandFragment.newInstance(model);
        californiaAdventure = CaliforniaAdventureFragment.newInstance(model);
        settings = SettingsFragment.newInstance();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment, disneyland)
                .commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
