package com.develop.windexit.finalproject;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by WINDEX IT on 23-Nov-17.
 */

public class MultiDexApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
