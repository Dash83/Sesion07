package com.iteso.marco.sesion07;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by marco on 3/4/15.
 */
public class MyPhoneReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle extras = intent.getExtras();
        if(extras != null)
        {
            String state = extras.get(TelephonyManager.EXTRA_STATE).toString();
            Log.v("PHONE_STATE", state);

            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                String phoneNumber = extras.get(TelephonyManager.EXTRA_INCOMING_NUMBER).toString();
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
                mBuilder.setSmallIcon(R.drawable.bender);
                mBuilder.setContentTitle("Notification alert! Click me!");
                mBuilder.setContentText("This is an Android notification yo!");

                Intent out = new Intent(context, MainActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
                stackBuilder.addParentStack(MainActivity.class);

                stackBuilder.addNextIntent(out);
                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(resultPendingIntent);

                NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1, mBuilder.build());
            }
        }
    }
}
