package io.github.aidenkoog.android.testapp;

import android.app.Application;
import android.content.Context;

public class TestApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        TestApp.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return TestApp.context;
    }
}
