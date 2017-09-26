package com.dystudio.toyapp;

import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dystudio.toyapp.util.LogUtil;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addActionBar(this);
        LogUtil.getLogger().log("onCreate:MainActivity");
    }

    public static void addActionBar(Context context) {
        Toolbar toolbar = (( AppCompatActivity)context).findViewById(R.id.toolbar);
        (( AppCompatActivity)context).setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Want to join me for pizza?");
        LogUtil.getLogger().log("onCreateOptionsMenu:MainActivity");
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        mShareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LogUtil.getLogger().log("onOptionsItemSelected:MainActivity");
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, DetailActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onShowDetails(View view) {
        LogUtil.getLogger().log("onShowDetails(responding to button click):MainActivity");
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.getLogger().log("onResume:MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.getLogger().log("onPause:MainActivity ---->");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.getLogger().log("onSaveInstanceState:MainActivity !!!!!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.getLogger().log("onStart:MainActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.getLogger().log("onRestart:MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.getLogger().log("onDestroy:MainActivity =========!!!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.getLogger().log("onStop:MainActivity");
    }
}
