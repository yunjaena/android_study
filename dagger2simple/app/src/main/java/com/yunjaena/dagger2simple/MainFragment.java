package com.yunjaena.dagger2simple;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

public class MainFragment extends DaggerFragment {
    @Inject
    @Named("app")
    String appString;

    @Inject
    @Named("activity")
    String activityString;

    @Inject
    @Named("fragment")
    String fragmentString;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        Log.e("MainFragment", appString);
        Log.e("MainFragment", activityString);
        Log.e("MainFragment", fragmentString);
        super.onAttach(context);
    }
}
