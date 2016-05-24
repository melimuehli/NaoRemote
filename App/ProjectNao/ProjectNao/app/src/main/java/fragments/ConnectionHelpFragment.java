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
public class ConnectionHelpFragment extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_connection_help);

        String message = "Um eine Verbindung mit Ihrem NAO herzustellen, geben Sie bitte seine IP Adresse ein. \n" +
                "Sollten Sie diese nicht kennen, drücken Sie einmal kurz auf den Brustknopf und Ihr NAO sagt neben seinem Namen auch die zugewiesene IP Adresse. (Hinweis: Ihr Smartphone und NAO müssen im selben Netzwerk registriert sein)\n";
        TextView textView = new TextView(this);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        textView.setTextSize(20);
        textView.setText(message);
        layout.addView(textView);
    }

}
