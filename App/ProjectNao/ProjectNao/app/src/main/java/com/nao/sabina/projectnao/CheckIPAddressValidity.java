package com.nao.sabina.projectnao;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Melanie on 11.05.16.
 * Description: This class checks the Validity of the entered IP-Address.
 */
public class CheckIPAddressValidity extends AsyncTask<Socket, Void, JSONObject> {

    private String host;
    private static int port = 9999;

    private String message = "";
    private InetAddress ip = null;

    public CheckIPAddressValidity(String host) {
        this.host = host;
    }

    public String isStringIPAddress() {
        try {
            ip = InetAddress.getByName(this.host);
        } catch (Exception e) {
            message = String.format("Please enter a valid IP-Address");

        }
        return message;
    }

    public String checkIpExists() {
        try {
            Process processReachability = java.lang.Runtime.getRuntime().exec("ping -c 1 " + this.host);
            int value = processReachability.waitFor();

            if (value != 0) {
                message = String.format("IP-Address could not be reached");
            }
        } catch (Exception e) {
            message = String.format("IP-Address could not be reached");
        }
        return message;
    }

    @Override
    protected JSONObject doInBackground(Socket... params) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), 9000);
            socket.close();
        } catch (Exception ex) {
            message = "Port is not open";
        }
        return null;
    }
}