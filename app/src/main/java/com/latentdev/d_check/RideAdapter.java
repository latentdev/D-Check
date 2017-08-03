package com.latentdev.d_check;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.latentdev.d_check.databinding.ListobjectBinding;

import java.util.List;

/**
 * Created by LatentDev on 7/27/2017.
 */


public class RideAdapter extends RecyclerView.Adapter<RideAdapter.BindingHolder> {

    private ObservableArrayList<Ride> mRides;
    private Context mContext;

    public RideAdapter(ObservableArrayList<Ride> mRides, Context mContext) {
        this.mRides = mRides;
        this.mContext = mContext;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListobjectBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.listobject, parent, false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ListobjectBinding binding = holder.binding;
        binding.setRvm(new RideViewModel(mRides.get(position), mContext));
    }

    @Override
    public int getItemCount() {
        return mRides.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ListobjectBinding binding;

        public BindingHolder(ListobjectBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

/*public class RideAdapter extends ArrayAdapter<Ride> {
    private LayoutInflater inflater;
    private ObservableArrayList<Ride> rides;
    private Context mContext;


    public RideAdapter(ObservableArrayList<Ride> rides, Context mContext){
        super(mContext,R.layout.listobject);
        this.rides = rides;
        this.mContext = mContext;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Ride ride = getItem(position);
        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        ListobjectBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.listobject, parent, false);
        /*
        TextView name = (TextView) convertView.findViewById(R.id.title);
        TextView waitTime = (TextView) convertView.findViewById(R.id.waittime);
        TextView status = (TextView) convertView.findViewById(R.id.status);
        TextView message = (TextView) convertView.findViewById(R.id.waitmessage);

        name.setText(ride.getName());
        waitTime.setText(ride.getWaitTime().getWaitTime()+ " minutes");
        status.setText(ride.getWaitTime().getRollUpStatus());
        message.setText(ride.getWaitTime().getRollUpWaitTimeMessage());
      binding.setRvm(new RideViewModel(ride,mContext));
        return binding.getRoot();
    }
}*/
