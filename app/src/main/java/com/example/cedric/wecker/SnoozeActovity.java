package com.example.cedric.wecker;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Cedric on 23.01.2018.
 */

public class SnoozeActovity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_snooze);
        Button snooueButton = findViewById(R.id.snooze);
        snooueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SnoozeActovity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(SnoozeActovity.this, 1234567, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                NotificationCompat.Builder notification = new NotificationCompat.Builder(SnoozeActovity.this, "Wecker")
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Neuer Alarm")
                        .setContentText("Neue Alarm Zeit")
                        .setContentIntent(pendingIntent);

                NotificationManager notifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notifyMgr.notify(1, notification.build());
                finish();
            }
        });
    }
}
