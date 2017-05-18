package apps.soma.com.fblc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import apps.soma.com.fblc.MainActivity;
import apps.soma.com.fblc.R;

/**
 * Created by issy on 4/27/17.
 */

public class LiveFragment extends Fragment {

    TextView streamOff;

    public LiveFragment() {
        // Required empty public constructor
    }

    //View Elements

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView;
        rootView    = inflater.inflate(R.layout.fragment_live, container, false);


        setUpView(rootView);

        return rootView;
    }

    public void setUpView(View v){
        streamOff   = (TextView) v.findViewById(R.id.stream_off_text);
        streamOff   .setTypeface(MainActivity.Roboto_BoldCondensed);
    }

}
