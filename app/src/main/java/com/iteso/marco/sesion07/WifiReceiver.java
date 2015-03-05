package com.iteso.marco.sesion07;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * Created by marco on 3/4/15.
 */
public class WifiReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        NetworkInfo networkInfo = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);

        if(networkInfo != null)
        {
            if(networkInfo.isConnected())
            {
                WifiManager manager = (WifiManager)context.getSystemService(context.WIFI_SERVICE);
                WifiInfo wifiInfo = manager.getConnectionInfo();
                Log.v("SSID",wifiInfo.getSSID().toString());
            }
        }
        else
        {
            Log.v("SSID", "Network info is null");
        }
    }
}
