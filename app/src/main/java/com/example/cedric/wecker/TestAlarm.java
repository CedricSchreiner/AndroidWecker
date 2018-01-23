package com.example.cedric.wecker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Cedric on 22.01.2018.
 */

public class TestAlarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent snoozeIntent = new Intent(context, SnoozeActovity.class);
        context.startActivity(snoozeIntent);
    }
}
