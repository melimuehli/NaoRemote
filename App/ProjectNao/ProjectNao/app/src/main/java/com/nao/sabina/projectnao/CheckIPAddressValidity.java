package com.nao.sabina.projectnao;

import android.widget.Toast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Melanie on 11.05.16.
 */
public class CheckIPAddressValidity {

    private String host;
    private static int port = 9999;

    private String message = "";
    private InetAddress ip = null;
    private boolean portIsOpen = false;


    public CheckIPAddressValidity(String host){
        this.host = host;
    }

    public String isStringIPAddress(){
        try {
            ip = InetAddress.getByName(this.host);
             portIsOpen = checkPortIsOpen();
            if(!portIsOpen){
                message = String.format("Port is not open");
            }
        } catch (Exception e){
            message = String.format("Please enter a valid IP-Address");

        }
        return message;
    }

    public String checkIpExists(){
        try {
            Process processReachability = java.lang.Runtime.getRuntime().exec("ping -c 1 " + this.host);
            int value = processReachability.waitFor();

            if(value != 0){
                message = String.format("IP-Address could not be reached");
            }
        } catch (Exception e) {
            message = String.format("IP-Address could not be reached");
        }
        return message;
    }

    private boolean checkPortIsOpen() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), 9000);
            socket.close();
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
