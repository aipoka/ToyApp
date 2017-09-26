package com.dystudio.toyapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.dystudio.toyapp.util.LogUtil;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.getLogger().log("onCreate:DetailActivity "+MainActivity.ACTIVITYCREATEDSYMBOL);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        MainActivity.addActionBar(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        WorkoutDetailFragment frag = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        frag.setWorkoutId(1);
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
