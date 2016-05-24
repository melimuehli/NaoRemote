package com.nao.sabina.projectnao;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

/**
 * Created by Melanie on 11.05.16.
 */
public class NetworkConnection {

    private String message = "";
    private boolean wifiEnabled = false;
    private boolean connectedWithWifi = false;

    public boolean checkWifiConnectivity(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if(!(mWifi.isConnected())) {
            connectedWithWifi = false;
            //message = "Please connect with your Wifi";
        }else{
            connectedWithWifi = true;
        }

        return connectedWithWifi;
    }

    public boolean checkWifiEnabled(Context context){
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);

        if(wifiManager.getWifiState() == WifiManager.WIFI_STATE_DISABLED){
            wifiEnabled = false;
        }
        else if(wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED){
            wifiEnabled = true;
        }

        return wifiEnabled;
    }
}
