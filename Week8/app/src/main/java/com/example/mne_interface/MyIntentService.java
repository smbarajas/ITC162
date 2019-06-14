package com.example.mne_interface;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

@SuppressLint("Registered")
public class MyIntentService extends IntentService {

    public static final String MESSAGE_KEY = "message_key";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("MyIntentService", "onHandleIntent");
        Intent returnIntent = new Intent("custom-event");
        returnIntent.putExtra(MESSAGE_KEY, "from the service");
        LocalBroadcastManager.getInstance(getApplicationContext())
                .sendBroadcast(returnIntent);
    }
}
