package com.latentdev.d_check;

import java.util.ArrayList;

/**
 * Created by LatentDev on 7/30/2017.
 */

public class Rides {
    private ArrayList<Ride> disneyland;
    private ArrayList<Ride> californiaAdventure;
    private int refreshInterval;

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
    Rides(ArrayList<Ride> disney,ArrayList<Ride> california)
    {
        disneyland = disney;
        californiaAdventure = california;
    }

    public void UpdateRides()
    {
        try {
            disneyland = JsonParser.getRides(new Network().execute("http://rides.azurewebsites.net/api/EndPoint/RefreshTimes").get());
            //california
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Loop()
    {
        //main loop
    }

}
