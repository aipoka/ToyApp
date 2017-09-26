package com.dystudio.toyapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dystudio.toyapp.util.LogUtil;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {

    private static final String WASUPFLAG = "wasup";
    private ShareActionProvider mShareActionProvider;

    public static final String ACTIVITYCREATEDSYMBOL = " a+++++++++++a";
    public static final String FRAGMENTCREATEDSYMBOL = " f+++++++++++f";
    public static final String VIEWCREATEDSYMBOL = " v++++++++++v";
    public static final String RESUMESYMBOL = " r@@@@@@@r";
    public static final String PAUSESYMBOL = " p######p";
    public static final String SAVESTATESYMBOL = " s______s";
    public static final String ACTIVITYDESTROYSYMBOL = " a-----------a";
    public static final String FRAGMENTDESTROYSYMBOL = " f-----------f";
    public static final String VIEWDESTROYSYMBOL = " v-----------v";

    private  boolean mWasUp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addActionBar(this);
        LogUtil.getLogger().log("onCreate:MainActivity " + ACTIVITYCREATEDSYMBOL);

        View fragmentContainer = findViewById(R.id.fragment_container);
        if(savedInstanceState!= null)
            mWasUp = savedInstanceState.getBoolean(WASUPFLAG);
        if (fragmentContainer != null && (!mWasUp)) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setWorkoutId(0);
            ft.add(R.id.fragment_container, details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }

    }

    public static void addActionBar(Context context) {
        Toolbar toolbar = ((AppCompatActivity) context).findViewById(R.id.toolbar);
        ((AppCompatActivity) context).setSupportActionBar(toolbar);
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

    @SuppressWarnings("SameParameterValue")
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

    @SuppressWarnings("unused")
    public void onShowDetails(View view) {
        LogUtil.getLogger().log("onShowDetails(responding to button click):MainActivity");
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWasUp = true;
        LogUtil.getLogger().log("onResume:MainActivity " + RESUMESYMBOL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.getLogger().log("onPause:MainActivity " + PAUSESYMBOL);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(WASUPFLAG, mWasUp);
        LogUtil.getLogger().log("onSaveInstanceState:MainActivity " + SAVESTATESYMBOL);
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
        LogUtil.getLogger().log("onDestroy:MainActivity " + ACTIVITYDESTROYSYMBOL);
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.getLogger().log("onStop:MainActivity");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.getLogger().log("onActivityResult:MainActivity:" + requestCode + ":" + resultCode + ":" + data);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        LogUtil.getLogger().log("itemClicked and fragment_container is "+fragmentContainer);
        if (fragmentContainer != null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setWorkoutId(id);
            ft.replace(R.id.fragment_container, details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
}
