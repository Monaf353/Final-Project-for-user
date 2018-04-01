package com.develop.windexit.finalproject.Helper;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;

import com.develop.windexit.finalproject.R;

/**
 * Created by WINDEX IT on 28-Mar-18.
 */

public class NotificationHelper extends ContextWrapper {


    private static final String PROJECT_ID= "com.develop.windexit.finalproject.FINAL_PROJECT";

    private static final String PROJECT_NAME= "Final Projct";
    private NotificationManager manager;
    public NotificationHelper(Context base) {
        super(base);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
            createChannel();
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel finalchannel= new NotificationChannel(
                PROJECT_ID, PROJECT_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        finalchannel.enableLights(false);
        finalchannel.enableVibration(true);
        finalchannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(finalchannel);
    }

    public NotificationManager getManager() {
        if(manager == null)
            manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;

    }
    @TargetApi(Build.VERSION_CODES.O)
    public Notification.Builder getFinalProjectNotification(String title, String body, PendingIntent contentIntent,
                                                Uri soundUri)
    {
        return new Notification.Builder(getApplicationContext(),PROJECT_ID)
                .setContentIntent(contentIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(soundUri)
                .setAutoCancel(true);
    }
}
