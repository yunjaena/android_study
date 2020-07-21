package com.yunjaena.dagger2android;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    String activityName;

    MainActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        component = ((App) getApplication()).getAppComponent()
                .mainActivityComponentBuilder()
                .setModule(new MainActivityModule())
                .setActivity(this)
                .build();
        component.inject(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MainFragment())
                .commit();
    }

    public MainActivityComponent getComponent() {
        return component;
    }
}
