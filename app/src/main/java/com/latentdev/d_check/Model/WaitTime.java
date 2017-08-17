package com.latentdev.d_check.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.latentdev.d_check.BR;
import com.latentdev.d_check.FastPass;

/**
 * Created by Laten on 7/26/2017.
 */

public class WaitTime extends BaseObservable {
    private FastPass fastPass;
    private String status;
    private boolean singleRider;
    private int waitTime;
    private String rollUpStatus;
    private String rollUpWaitTimeMessage;

    public FastPass getFastPass() {
        return fastPass;
    }

    public void setFastPass(FastPass fastPass) {
        this.fastPass = fastPass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSingleRider() {
        return singleRider;
    }

    public void setSingleRider(boolean singleRider) {
        this.singleRider = singleRider;
    }
    @Bindable
    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
        notifyPropertyChanged(BR.waitTime);
    }
    @Bindable
    public String getRollUpStatus() {
        return rollUpStatus;
    }

    public void setRollUpStatus(String rollUpStatus) {
        this.rollUpStatus = rollUpStatus;
        notifyPropertyChanged(BR.status);
    }
    @Bindable
    public String getRollUpWaitTimeMessage() {
        return rollUpWaitTimeMessage;
    }

    public void setRollUpWaitTimeMessage(String rollUpWaitTimeMessage) {
        this.rollUpWaitTimeMessage = rollUpWaitTimeMessage;
        notifyPropertyChanged(BR.message);
    }
}
