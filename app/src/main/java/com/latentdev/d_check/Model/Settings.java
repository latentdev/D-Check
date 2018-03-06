package com.latentdev.d_check.Model;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;

/**
 * Created by Laten on 8/17/2017.
 */

public class Settings extends BaseObservable {

    public ObservableInt interval;
    public ObservableBoolean keepTimeUpdated;
    Settings()
    {
        interval = new ObservableInt(5);
        keepTimeUpdated = new ObservableBoolean(false);
    }
}
