package com.latentdev.d_check.Model;

import android.databinding.BaseObservable;
import android.databinding.ObservableInt;

/**
 * Created by Laten on 8/17/2017.
 */

public class Settings extends BaseObservable {
    private ObservableInt interval;
    Settings()
    {
        interval = new ObservableInt(5);
    }
}
