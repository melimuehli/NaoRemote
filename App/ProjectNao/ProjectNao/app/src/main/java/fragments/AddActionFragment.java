package fragments;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nao.sabina.projectnao.R;

public class AddActionFragment extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_action);

        String message = "BLALBALBA \n blablabla";
        TextView textView = new TextView(this);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.fragment_add_action);
        textView.setTextSize(40);
        textView.setText(message);
        layout.addView(textView);
    }

}
