package fragments;
import android.content.Intent;
import android.net.Network;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nao.sabina.projectnao.CheckIPAddressValidity;
import com.nao.sabina.projectnao.NetworkConnection;
import com.nao.sabina.projectnao.R;

/**
 * ConnectWithNaoFragment
 * Author: Sabina Brantner
 * Description: In this class/fragment the user is able to connect with ones Nao. Moreover, there
 * is also a help button which describes how to connect.
 */
public class ConnectWithNaoFragment extends Fragment {

    boolean connectedWithWifi = false;

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_connect_with_nao,container,false);
        Button buttonHelp = (Button) v.findViewById(R.id.helpConnectionButton);
        Button buttonConnect = (Button) v.findViewById(R.id.connectButton);

        final EditText ipText = (EditText)v.findViewById(R.id.ipOfNaoView);

        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNetworkInformation();

                if(connectedWithWifi) {
                    checkUserInput(v, ipText.getText().toString());
                }
            }
        });

        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConnectionHelp(v);
            }
        });

        return v;
    }

    public void showConnectionHelp(View view) {
        Intent intent = new Intent(this.getActivity(), ConnectionHelpFragment.class);
        startActivity(intent);
    }

    private void checkUserInput(View view, String ipAdress){

        String message = "";

        if(ipAdress.isEmpty()){
            Toast.makeText(getContext(), "Please enter a IP-Address!", Toast.LENGTH_SHORT).show();
        }
        else{
            CheckIPAddressValidity ipValidityChecker = new CheckIPAddressValidity(ipAdress);
            message = ipValidityChecker.isStringIPAddress();

            if(message.isEmpty()){
                message = ipValidityChecker.checkIpExists();

                if(message.isEmpty()){
                    message = String.format("IP-Address correct");
                }
            }

            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    private void getNetworkInformation(){
        String message = "";
        boolean wifiEnabled = false;

        NetworkConnection networkInformation = new NetworkConnection();
        wifiEnabled = networkInformation.checkWifiEnabled(getContext());

        if(wifiEnabled){
            connectedWithWifi = networkInformation.checkWifiConnectivity(getContext());
            if(!connectedWithWifi){
                Toast.makeText(getContext(), "Please connect to your Wifi", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getContext(), "Please turn on your Wifi", Toast.LENGTH_SHORT).show();
        }
    }
}