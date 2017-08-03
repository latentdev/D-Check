package com.latentdev.d_check;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Laten on 7/27/2017.
 */

public class JsonParser
{
    static public ArrayList<Ride> getRides(String json)
    {
        ArrayList<Ride> rides= new ArrayList<>();
        JSONTokener tokener = new JSONTokener(json);

        try{
            JSONArray array = (JSONArray) tokener.nextValue();
            int i = 0;
            while (!array.isNull(i)) {
                JSONObject object = (JSONObject) array.getJSONObject(i);
                if(object!=null) {
                    Ride ride = new Ride();
                    ride.setId(object.getInt("id"));
                    ride.setName(object.getString("name"));
                    ride.setType(object.getString("type"));

                    JSONObject jWaitTime = object.getJSONObject("waitTime");
                    if(jWaitTime!=null) {
                        JSONObject jFastPass = jWaitTime.getJSONObject("fastPass");
                        if (jFastPass != null) {
                            FastPass fastPass = new FastPass();
                            if(jFastPass.getString("start")!="null")
                                fastPass.setStart((Date) jFastPass.get("start"));
                            if(jFastPass.getString("end")!="null")
                                fastPass.setEnd((Date) jFastPass.get("end"));
                            fastPass.setAvailable(jFastPass.getBoolean("available"));
                            WaitTime waitTime = new WaitTime();
                            waitTime.setFastPass(fastPass);
                            waitTime.setStatus(jWaitTime.getString("status"));
                            waitTime.setSingleRider(jWaitTime.getBoolean("singleRider"));
                            waitTime.setWaitTime(jWaitTime.getInt("postedWaitMinutes"));
                            waitTime.setRollUpStatus(jWaitTime.getString("rollUpStatus"));
                            waitTime.setRollUpWaitTimeMessage(jWaitTime.getString("rollUpWaitTimeMessage"));
                            ride.setWaitTime(waitTime);
                        }
                    }
                    i++;
                    rides.add(ride);
                }
            }

        }catch (JSONException e)
        {
            Log.e("error",e.toString());
        }
        return rides;
    }

}
