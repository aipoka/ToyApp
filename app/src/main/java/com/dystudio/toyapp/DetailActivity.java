package com.dystudio.toyapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.dystudio.toyapp.util.LogUtil;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.getLogger().log("onCreate:DetailActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.getLogger().log("onResume:DetailActivity");

    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.getLogger().log("onPause:DetailActivity ---->");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.getLogger().log("onSaveInstanceState:DetailActivity !!!!");
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
        LogUtil.getLogger().log("onDestroy:DetailActivity =========!!!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.getLogger().log("onStop:DetailActivity");
    }
}
