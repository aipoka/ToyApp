package com.dystudio.toyapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dystudio.toyapp.util.LogUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    private long mWorkoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
        LogUtil.getLogger().log("WorkoutDetailFragment constructor:WorkoutDetailFragment " + MainActivity.FRAGMENTCREATEDSYMBOL);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LogUtil.getLogger().log("onCreateView : WorkoutDetailFragment " + MainActivity.VIEWCREATEDSYMBOL);
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);

    }

    public void setWorkoutId(long workoutId) {
        mWorkoutId = workoutId;
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.getLogger().log("onPause:WorkoutDetailFragment " + MainActivity.PAUSESYMBOL);
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.getLogger().log("onResume:WorkoutDetailFragment " + MainActivity.RESUMESYMBOL);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.getLogger().log("onSaveInstanceState:WorkoutDetailFragment " + MainActivity.SAVESTATESYMBOL);
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.getLogger().log("onStart:WorkoutDetailFragment");
        View view = getView();
        if (view != null) {
            TextView title = view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) mWorkoutId];
            title.setText(workout.getName());
            TextView description = view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.getLogger().log("onDestroy:WorkoutDetailFragment " + MainActivity.FRAGMENTDESTROYSYMBOL);
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.getLogger().log("onStop:WorkoutDetailFragment");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtil.getLogger().log("onAttach:WorkoutDetailFragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.getLogger().log("onDestroyView:WorkoutDetailFragment " + MainActivity.VIEWDESTROYSYMBOL);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.getLogger().log("onDetach:WorkoutDetailFragment");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.getLogger().log("onActivityCreated:WorkoutDetailFragment " + MainActivity.ACTIVITYCREATEDSYMBOL);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.getLogger().log("onActivityResult:WorkoutDetailFragment" + requestCode + ":" + resultCode + ":" + data);
    }
}
