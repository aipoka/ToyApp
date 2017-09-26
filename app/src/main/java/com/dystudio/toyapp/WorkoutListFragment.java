package com.dystudio.toyapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dystudio.toyapp.util.LogUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {

    static interface Listener {
        void itemClicked(long id);
    }

    private Listener mListener;

    public WorkoutListFragment() {
        // Required empty public constructor
        LogUtil.getLogger().log("WorkoutListFragment Constructor "+MainActivity.FRAGMENTCREATEDSYMBOL);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                names);
        setListAdapter(adapter);
        LogUtil.getLogger().log("onCreateView:WorkoutListFragment "+MainActivity.VIEWCREATEDSYMBOL);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtil.getLogger().log("onAttach:WorkoutListFragment");
        this.mListener = (Listener) context;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (mListener != null) {
            LogUtil.getLogger().log("onListItemClick:WorkoutListFragment:"+l+":"+v+":"+position+":"+id);
            mListener.itemClicked(id);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.getLogger().log("onPause:WorkoutListFragment " + MainActivity.PAUSESYMBOL);
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.getLogger().log("onResume:WorkoutListFragment " + MainActivity.RESUMESYMBOL);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.getLogger().log("onSaveInstanceState:WorkoutListFragment " + MainActivity.SAVESTATESYMBOL);

    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.getLogger().log("onStart:WorkoutListFragment");

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.getLogger().log("onDestroy:WorkoutListFragment " + MainActivity.FRAGMENTDESTROYSYMBOL);
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.getLogger().log("onStop:WorkoutListFragment");
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.getLogger().log("onDestroyView:WorkoutListFragment " + MainActivity.VIEWDESTROYSYMBOL);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.getLogger().log("onDetach:WorkoutListFragment");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.getLogger().log("onActivityCreated:WorkoutListFragment " + MainActivity.ACTIVITYCREATEDSYMBOL);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.getLogger().log("onActivityResult:WorkoutListFragment" + requestCode + ":" + resultCode + ":" + data);
    }
}
