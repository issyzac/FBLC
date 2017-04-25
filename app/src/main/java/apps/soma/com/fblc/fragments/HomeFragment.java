package apps.soma.com.fblc.fragments;

/**
 * Created by issy on 4/21/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.bumptech.glide.Glide;

import apps.soma.com.fblc.R;

/**
 * Created by issy on 9/28/16.
 */

public class HomeFragment extends Fragment{

    public HomeFragment() {
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
        rootView    = inflater.inflate(R.layout.fragment_home, container, false);


        setUpView(rootView);

        return rootView;
    }

    public void setUpView(View v){

    }

}
