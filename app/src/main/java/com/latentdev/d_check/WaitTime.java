package com.latentdev.d_check;

/**
 * Created by Laten on 7/26/2017.
 */

public class WaitTime {
    public FastPass fastPass;
    public String status;
    public boolean singleRider;
    public int waitTime;
    public String rollUpStatus;
    public String rollUpWaitTimeMessage;

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

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public String getRollUpStatus() {
        return rollUpStatus;
    }

    public void setRollUpStatus(String rollUpStatus) {
        this.rollUpStatus = rollUpStatus;
    }

    public String getRollUpWaitTimeMessage() {
        return rollUpWaitTimeMessage;
    }

    public void setRollUpWaitTimeMessage(String rollUpWaitTimeMessage) {
        this.rollUpWaitTimeMessage = rollUpWaitTimeMessage;
    }
}
