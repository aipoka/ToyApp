package com.dystudio.toyapp;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment //implements View.OnClickListener{
{
    private static final String SECONDS = "totalSeconds" ;
    private static final String ISRUNNING = "isrunning";
    private static final String WASRUNNING = "wasrunning";
    private int mSeconds = 0;
    private boolean mIsRunning;
    private boolean mWasRunning;

    public StopwatchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mSeconds = savedInstanceState.getInt(SECONDS);
            mIsRunning = savedInstanceState.getBoolean(ISRUNNING);
            mWasRunning = savedInstanceState.getBoolean(WASRUNNING);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        Button startButton = layout.findViewById(R.id.start_button);
        startButton.setOnClickListener((View v)->{onClickStart();});
        Button stopButton = layout.findViewById(R.id.stop_button);
        stopButton.setOnClickListener((View v)->{onClickStop();});
        Button resetButton = layout.findViewById(R.id.reset_button);
        resetButton.setOnClickListener((View v)->{onClickReset();});
        runTimer(layout);
        return layout;
        
    }



    @Override
    public void onPause() {
        super.onPause();
        mWasRunning = mIsRunning;
        mIsRunning = false;
    }
    @Override
    public void onResume() {
        super.onResume();
        if (mWasRunning) {
            mIsRunning = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(SECONDS, mSeconds);
        savedInstanceState.putBoolean(ISRUNNING, mIsRunning);
        savedInstanceState.putBoolean(WASRUNNING, mWasRunning);
    }

    private void onClickStart() {
        mIsRunning = true;
    }

    private void onClickStop() {
        mIsRunning = false;
    }
    private  void onClickReset() {
        mIsRunning = false;
        mSeconds = 0;
    }

    private void runTimer(View view) {
        final TextView timeView = (TextView) view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = mSeconds/3600;
                int minutes = (mSeconds%3600)/60;
                int secs = mSeconds%60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (mIsRunning) {
                    mSeconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.start_button:
//                onClickStart();
//                break;
//            case R.id.stop_button:
//                onClickStop();
//                break;
//            case R.id.reset_button:
//                onClickReset();
//                break;
//        }
//    }
}
