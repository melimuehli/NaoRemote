package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nao.sabina.projectnao.R;
import com.squareup.picasso.Picasso;

/**
 * NaoInfoFragment
 * Author: Sabina Brantner
 * Description: This Fragment show all the infos about a Nao(f.i. Battery  status, temperature)
 */
public class NaoInfoFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nao_info,container,false);
        ImageView imageViewBattery = ((ImageView) v.findViewById(R.id.imageBattery));
        Picasso.with(getContext()).load(R.drawable.full_battery).fit().centerInside().into(imageViewBattery);

        ImageView imageViewAppearance = ((ImageView) v.findViewById(R.id.Apperance));
        Picasso.with(getContext()).load(R.drawable.sitting_nao).fit().centerInside().into(imageViewAppearance);

        ImageView imageViewSignalStrength = ((ImageView) v.findViewById(R.id.imageSignalStrength));
        Picasso.with(getContext()).load(R.drawable.wireless_full).fit().centerInside().into(imageViewSignalStrength);

        ImageView imageViewTemperature = ((ImageView) v.findViewById(R.id.temperatureImage));
        Picasso.with(getContext()).load(R.drawable.temperature).fit().centerInside().into(imageViewTemperature);

        return v;
    }
}
