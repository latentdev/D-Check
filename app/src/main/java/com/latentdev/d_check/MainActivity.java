package com.latentdev.d_check;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import com.latentdev.d_check.databinding.ActivityMainBinding;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //public TextView mTextMessage;
    public RecyclerView disneyListView;

    //Network net;
    MainActivity activity = this;
    //public ObservableArrayList rides;// = new ArrayList<>();
    Rides model;
    ActivityMainBinding binding;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    //net = new Network();
                    /*try {
                        rides = model.getDisneyLand();//JsonParser.getRides(net.execute(getString(R.string.disneyland_rides)).get());
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }*/
                    /*rides = model.getDisneyland();
                    disneyListView = (RecyclerView) findViewById(R.id.disneyrecyclerview);*/
                    RideAdapter adapter;
                    adapter =  new RideAdapter(model.getDisneyland(), activity);
                    binding.disneyrecyclerview.setAdapter((adapter));
                    return true;
                }
                case R.id.navigation_dashboard: {

                    binding.disneyrecyclerview.setAdapter(null);
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                }
                case R.id.navigation_notifications: {
                    binding.disneyrecyclerview.setAdapter(null);
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
        disneyListView = (RecyclerView) findViewById(R.id.disneyrecyclerview);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.disneyrecyclerview.setLayoutManager(layoutManager);

        model = new Rides();
        model.Start();

        RideAdapter adapter = new RideAdapter(model.getDisneyland(), this);
        binding.disneyrecyclerview.setAdapter(adapter);
        /*net = new Network();
        try {
            rides = JsonParser.getRides(net.execute(getString(R.string.disneyland_rides)).get());
        }catch (Exception e)
        {
            e.printStackTrace();
        }*/

    }

}
