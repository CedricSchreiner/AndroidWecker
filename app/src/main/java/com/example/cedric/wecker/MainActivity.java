package com.example.cedric.wecker;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import junit.framework.Test;

import java.util.Calendar;
import java.util.logging.Logger;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimePicker timePicker = findViewById(R.id.alarmPicker);
        timePicker.setIs24HourView(true);
        timePicker.setHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

        final Button button = findViewById(R.id.startAlarm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePicker timePicker = findViewById(R.id.alarmPicker);

                Toast.makeText(MainActivity.this, String.valueOf(timePicker.getHour()) + " " + String.valueOf(timePicker.getMinute()), Toast.LENGTH_SHORT).show();
                createAlarm();

            }
        });
    }

    private void createAlarm() {
        //Create an offset from the current time in which the alarm will go off.
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(Calendar.SECOND, 5);

        //Create a new PendingIntent and add it to the AlarmManager
        Intent intent = new Intent(MainActivity.this, TestAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager am = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
    }
}
