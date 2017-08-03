package com.latentdev.d_check;

import android.databinding.ObservableArrayList;
import android.os.SystemClock;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by LatentDev on 7/30/2017.
 */

public class Rides{
    private ObservableArrayList<Ride> disneyland;
    private ArrayList<Ride> californiaAdventure;
    private long refreshInterval = 1;
    private volatile boolean running = true;
    private Calendar c = Calendar.getInstance();
    private long lastInterval = 0;
    private long currentMinute;

    Rides()
    {
        try {
            disneyland = JsonParser.getRides(new Network().execute("http://rides.azurewebsites.net/api/EndPoint/RefreshTimes").get());
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        //code to fetch california adventure rides
    }

    Rides(ObservableArrayList<Ride> disney,ArrayList<Ride> california)
    {
        disneyland = disney;
        californiaAdventure = california;
    }

    public void UpdateRides()
    {
        try {
            disneyland = JsonParser.getRides(new Network().execute("http://rides.azurewebsites.net/api/EndPoint/RefreshTimes").get());
            notify();
            //california
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Start()
    {
        running = true;
        new Thread(new Runnable() {
            public void run() {
                Loop();
            }
        }).start();
    }

    public void Stop()
    {
        running = false;
    }

    public void Loop()
    {
        while (running) {
            currentMinute = (SystemClock.elapsedRealtime()/1000)/60;
            if (currentMinute-lastInterval>=refreshInterval)
            {
                UpdateRides();
                lastInterval=currentMinute;
                Log.d("Update","5 mins passed. New Rides were fetched. lastInterval = "+lastInterval);
                //notify UI of update
            }
            //else
                //Log.d("Update","lastInterval = "+lastInterval);
            // do something in the loop
        }
    }

    public ObservableArrayList<Ride> getDisneyland() {
        return disneyland;
    }
}
