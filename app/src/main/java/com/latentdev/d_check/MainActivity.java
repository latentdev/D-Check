package com.latentdev.d_check;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //public TextView mTextMessage;
    public ListView disneyListView;

    Network net;
    MainActivity activity = this;
    public ArrayList<Ride> rides;// = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    net = new Network();
                    try {
                        rides = JsonParser.getRides(net.execute(getString(R.string.disneyland_rides)).get());
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    disneyListView = (ListView) findViewById(R.id.disneylistview);
                    RideAdapter adapter;
                    adapter =  new RideAdapter(activity,rides);
                    disneyListView.setAdapter((adapter));
                    return true;
                }
                case R.id.navigation_dashboard: {

                    disneyListView.setAdapter(null);
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                }
                case R.id.navigation_notifications: {
                    disneyListView.setAdapter(null);
                    //mTextMessage.setText(R.string.title_notifications);
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

        //mTextMessage = (TextView) findViewById(R.id.message);
        disneyListView = (ListView) findViewById(R.id.disneylistview);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        net = new Network();
        try {
            rides = JsonParser.getRides(net.execute(getString(R.string.disneyland_rides)).get());
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
