package com.example.cs125finalproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    MediaPlayer media;
    boolean playing = false;
    //Intent i;
    @Override
    public void onReceive(Context context, Intent intent) {
        //i = intent;
        media = MediaPlayer.create(context, R.raw.alarm);

        Log.e("In Receiver", "here");
        String onOff = intent.getStringExtra("extra");
        if (onOff.equals("on")) {
            media.start();
            Log.e("In receiver", "start");
            playing = true;
        }
        if (onOff.equals("off")) {
            stop();
            //media.seekTo(0);
            //media.pause();
            //media.release();
            //media = null;
            //media.reset();
            Log.e("In receiver", "stop");

        }

    }
    public void stop() {
        media.stop();
        //media.release()
        Log.e("stop method", "here");
    }
}
