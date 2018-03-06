package com.latentdev.d_check;

import android.app.Application;

/**
 * Created by LatentDev on 3/5/2018.
 */

public class ExtendedApplication extends Application {
    private Boolean keepTimesUpdated;
    private int updateInterval;

    @Override
    public void onCreate() {
        // Here you could pull values from a config file in res/raw or somewhere else
        // but for simplicity's sake, we'll just hardcode values
        keepTimesUpdated = false;
        updateInterval = 5;
        super.onCreate();
    }

    public boolean getKeepTimesUpdated() {
        return keepTimesUpdated;
    }

    public void setKeepTimesUpdated(boolean value) {
        keepTimesUpdated = value;
    }

    public int getUpdateInterval() {
        return updateInterval;
    }

    public void setUpdateInterval(int value) {
        updateInterval = value;
    }
}
