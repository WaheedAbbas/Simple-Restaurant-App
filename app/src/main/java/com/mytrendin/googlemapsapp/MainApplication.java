package com.mytrendin.googlemapsapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import co.uk.rushorm.android.AndroidInitializeConfig;
import co.uk.rushorm.core.Rush;
import co.uk.rushorm.core.RushCore;

/**
 * Created by ATTech_Android_1 on 02/05/2018.
 */

public class MainApplication extends Application {

    /*
    when our app is created.
     */
    @Override
    public void onCreate() {
        super.onCreate();

        AndroidInitializeConfig config=new AndroidInitializeConfig(getApplicationContext());
        List<Class<? extends Rush>> classes = new ArrayList<>();
        classes.add(RushORM.class);
        config.setClasses(classes);
        RushCore.initialize(config);

    }
}
