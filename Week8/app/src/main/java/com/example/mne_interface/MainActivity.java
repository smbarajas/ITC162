package com.example.mne_interface;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mLog;
    private BroadcastReceiver br;

    BroadcastReceiver mLocalReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra(MyIntentService.MESSAGE_KEY);
            logMessage("Received: " + message);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLog = findViewById(R.id.log);
        mLog.setMovementMethod(new ScrollingMovementMethod());
        mLog.setText("");

        br = new MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        registerReceiver(br, filter);

        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(mLocalReceiver, new IntentFilter("custom-event"));
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(br);
        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(mLocalReceiver);
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null) {
            String message = intent.getStringExtra("payload");
            if (message != null) {
                logMessage(message);
            }
        }
    }

    private void logMessage(String message) {
//      Output message to logcat console
        Log.i(TAG, message);

//      Output message to TextView
        mLog.append(message + "\n");

//      Adjust scroll position to make last line visible
        Layout layout = mLog.getLayout();
        if (layout != null) {
            int scrollAmount = layout.getLineTop(mLog.getLineCount()) - mLog.getHeight();
            mLog.scrollTo(0, scrollAmount > 0 ? scrollAmount : 0);
        }
    }

    public void runCode(View view) {
        Intent intent = new Intent(this, MyReceiver.class);
        intent.putExtra("payload", "From the original intent");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                getApplicationContext(), 1, intent, 0
        );
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, pendingIntent);
        logMessage("Alarm set in 3 seconds");
    }

    public void clearLog(View view) {
        mLog.setText("");
        mLog.scrollTo(0, 0);
    }

    class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            logMessage("Action: " + intent.getAction());
        }
    }

}