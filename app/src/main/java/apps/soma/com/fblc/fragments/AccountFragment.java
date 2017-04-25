package apps.soma.com.fblc.fragments;

/**
 * Created by issy on 4/23/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import apps.soma.com.fblc.MainActivity;
import apps.soma.com.fblc.R;

/**
 * Created by issy on 9/28/16.
 */

public class AccountFragment extends Fragment {

    TextView notAuthenticated, authenticateButton, acountTitle;

    public AccountFragment() {
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
        rootView    = inflater.inflate(R.layout.fragment_account, container, false);


        setUpView(rootView);

        return rootView;
    }

    public void setUpView(View v){
        notAuthenticated    = (TextView) v.findViewById(R.id.not_authenticated);
        notAuthenticated    .setTypeface(MainActivity.Rosario_Regular);
        authenticateButton  = (TextView) v.findViewById(R.id.authenticate);
        authenticateButton  .setTypeface(MainActivity.Rosario_Regular);
        acountTitle         = (TextView) v.findViewById(R.id.account_title);
        acountTitle         .setTypeface(MainActivity.Rosario_Regular);
    }

}
