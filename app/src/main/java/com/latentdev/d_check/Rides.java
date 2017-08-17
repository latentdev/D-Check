package com.latentdev.d_check;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.os.SystemClock;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by LatentDev on 7/30/2017.
 */

public class Rides extends BaseObservable implements Serializable{
    private ObservableArrayList<Ride> disneyland;
    private ObservableArrayList<Ride> californiaAdventure;
    //private ObservableArrayList<Ride> empty;
    private long refreshInterval = 5;
    private volatile boolean running = true;
    private Calendar c = Calendar.getInstance();
    private long lastInterval = 0;
    private long currentMinute;

    Rides()
    {
        try {
            disneyland = new ObservableArrayList<>();
            californiaAdventure = new ObservableArrayList<>();
            //empty = new ObservableArrayList<>();
            JsonParser.getRides(new Network().execute("http://rides.azurewebsites.net/api/EndPoint/DisneyLandTimes").get(),disneyland);
            JsonParser.getRides(new Network().execute("http://rides.azurewebsites.net/api/EndPoint/CaliforniaAdventureTimes").get(),californiaAdventure);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    Rides(ObservableArrayList<Ride> disney,ObservableArrayList<Ride> california)
    {
        disneyland = disney;
        californiaAdventure = california;
    }

    public void UpdateRides()
    {
        try {
            JsonParser.getRides(new Network().execute("http://rides.azurewebsites.net/api/EndPoint/DisneyLandTimes").get(),disneyland);
            JsonParser.getRides(new Network().execute("http://rides.azurewebsites.net/api/EndPoint/CaliforniaAdventureTimes").get(),californiaAdventure);
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

    public ObservableArrayList<Ride> getCaliforniaAdventure() { return californiaAdventure; }

    /*public ObservableArrayList<Ride> getEmpty() {
        return empty;
    }*/

    /*public void setEmpty(ObservableArrayList<Ride> empty) {
        this.empty = empty;
    }*/
}
