package com.latentdev.d_check.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.latentdev.d_check.BR;

/**
 * Created by LatentDev on 7/23/2017.
 */

public class Ride extends BaseObservable {
    private int id;
    private String name;
    private String type;
    private WaitTime waitTime;
    private boolean check;

    public Ride()
    {
        check = false;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        //notifyPropertyChanged(BR.id);
    }
    @Bindable
    public String getName() {
        return name;}

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.title);
    }
    @Bindable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Bindable
    public WaitTime getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(WaitTime waitTime) {
        this.waitTime = waitTime;
    }
    @Bindable
    public boolean isCheck() {
        return check;
    }
    @Bindable
    public void setCheck(boolean check) {
        this.check = check;
        notifyPropertyChanged(BR.check);
    }
}
