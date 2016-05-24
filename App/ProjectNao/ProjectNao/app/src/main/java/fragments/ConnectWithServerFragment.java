package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nao.sabina.projectnao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConnectWithServerFragment extends Fragment {


    public ConnectWithServerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_connect_with_server, container, false);
    }

}
