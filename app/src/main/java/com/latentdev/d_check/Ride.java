package com.latentdev.d_check;

import android.databinding.BaseObservable;

/**
 * Created by Laten on 7/23/2017.
 */

public class Ride extends BaseObservable {
    private int id;
    private String name;
    private String type;
    private WaitTime waitTime;
    private boolean check;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WaitTime getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(WaitTime waitTime) {
        this.waitTime = waitTime;
    }
}
