package com.dystudio.toyapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dystudio.toyapp.util.LogUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {


    public WorkoutDetailFragment() {
        // Required empty public constructor
        LogUtil.getLogger().log("WorkoutDetailFragment constructor:WorkoutDetailFragment");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LogUtil.getLogger().log("onCreateView : WorkoutDetailFragment");
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);

    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.getLogger().log("onPause:WorkoutDetailFragment ---->");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.getLogger().log("onResume:WorkoutDetailFragment");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.getLogger().log("onSaveInstanceState:WorkoutDetailFragment ^^^^");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.getLogger().log("onStart:WorkoutDetailFragment");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.getLogger().log("onDestroy:WorkoutDetailFragment =========!!!!");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.getLogger().log("onStop:WorkoutDetailFragment");
    }
}
