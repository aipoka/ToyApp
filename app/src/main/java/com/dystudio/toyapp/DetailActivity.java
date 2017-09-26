package com.dystudio.toyapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dystudio.toyapp.util.LogUtil;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.getLogger().log("onCreate:DetailActivity "+MainActivity.ACTIVITYCREATEDSYMBOL);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        MainActivity.addActionBar(this);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        WorkoutDetailFragment frag = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if(bundle != null) {
                int workoutId = (int) bundle.get(EXTRA_WORKOUT_ID);
                frag.setWorkoutId(workoutId);
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.getLogger().log("onResume:DetailActivity "+MainActivity.RESUMESYMBOL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.getLogger().log("onPause:DetailActivity "+MainActivity.PAUSESYMBOL);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.getLogger().log("onSaveInstanceState:DetailActivity "+MainActivity.SAVESTATESYMBOL);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.getLogger().log("onStart:DetailActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.getLogger().log("onRestart:DetailActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.getLogger().log("onDestroy:DetailActivity "+MainActivity.ACTIVITYDESTROYSYMBOL);
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.getLogger().log("onStop:DetailActivity");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.getLogger().log("onActivityResult:DetailActivity:"+requestCode+":"+resultCode+":"+data);
    }
}
