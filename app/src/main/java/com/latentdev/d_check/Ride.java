package com.latentdev.d_check;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Laten on 7/23/2017.
 */

public class Ride extends BaseObservable {
    private int id;
    private String name;
    private String type;
    private WaitTime waitTime;
    private boolean check;
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
}
