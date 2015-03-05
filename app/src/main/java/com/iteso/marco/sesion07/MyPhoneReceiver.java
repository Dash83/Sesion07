package com.iteso.marco.sesion07;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
                Log.v("PHONE_STATE", "Incoming number=" + phoneNumber);
            }
        }
    }
}
