package com.example.cedric.wecker;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimePicker timePicker = findViewById(R.id.alarmPicker);
        timePicker.setIs24HourView(true);
        timePicker.setHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

        Button button = findViewById(R.id.startAlarm);


        AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent alarmIntent = new Intent(MainActivity.this, TestAlarm.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePicker timePicker = findViewById(R.id.alarmPicker);

                Toast.makeText(MainActivity.this, String.valueOf(timePicker.getHour()) + " " + String.valueOf(timePicker.getMinute()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
