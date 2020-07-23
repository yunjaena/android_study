package com.yunjaena.dagger2simple;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    @Inject
    @Named("app")
    String appString;

    @Inject
    @Named("activity")
    String activityString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        Log.e("MainActivity", appString);
        Log.e("MainActivity", activityString);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MainFragment())
                .commit();
    }
}
