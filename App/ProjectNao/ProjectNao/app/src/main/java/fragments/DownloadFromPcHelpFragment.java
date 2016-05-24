package fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nao.sabina.projectnao.R;

/*
 * ConnectionHelpFragment
 * Author: Sabina Brantner
 * Description: This Fragment shows you a text which describes how to connect with the Nao
 */
public class DownloadFromPcHelpFragment extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_connection_help);

        String message = "Damit Sie heruntergeladene Actions auf Ihr Smartphone übertragen können, stecken Sie dieses mithilfe eines USB Kabels an Ihren PC an. Kann auf den internen Speicher zugegriffen werden, fügen Sie die gewünschte Action in den Ordner „ProjectNao“ ein.";
        TextView textView = new TextView(this);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        textView.setTextSize(40);
        textView.setText(message);
        layout.addView(textView);
    }

}
