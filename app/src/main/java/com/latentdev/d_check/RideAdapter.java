package com.latentdev.d_check;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LatentDev on 7/27/2017.
 */

public class RideAdapter extends ArrayAdapter<Ride> {

    public RideAdapter(Context context, ArrayList<Ride> rides){
        super(context,0,rides);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Ride ride = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listobject, parent, false);

        }
        TextView name = (TextView) convertView.findViewById(R.id.title);
        TextView waitTime = (TextView) convertView.findViewById(R.id.waittime);
        TextView status = (TextView) convertView.findViewById(R.id.status);
        TextView message = (TextView) convertView.findViewById(R.id.waitmessage);

        name.setText(ride.getName());
        waitTime.setText(ride.getWaitTime().getWaitTime()+ " minutes");
        status.setText(ride.getWaitTime().getRollUpStatus());
        message.setText(ride.getWaitTime().getRollUpWaitTimeMessage());

        return convertView;
    }
}
