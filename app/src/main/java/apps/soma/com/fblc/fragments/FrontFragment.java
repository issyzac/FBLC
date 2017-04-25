package apps.soma.com.fblc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import apps.soma.com.fblc.MainActivity;
import apps.soma.com.fblc.R;
import apps.soma.com.fblc.adapter.FrontRecyclerAdapter;
import apps.soma.com.fblc.datamodels.Sermon;

/**
 * Created by issy on 4/23/17.
 */

public class FrontFragment extends Fragment {

    TextView ibadaTitle, authenticateButton, acountTitle;
    RecyclerView frontRecyclerview;

    public FrontFragment() {
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
        rootView    = inflater.inflate(R.layout.fragment_front, container, false);


        setUpView(rootView);
        YoutubeFragment fragment = new YoutubeFragment();
        FragmentManager manager = this.getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.main, fragment)
                .addToBackStack(null)
                .commit();

        LinearLayoutManager layoutManager = new LinearLayoutManager(FrontFragment.this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        frontRecyclerview.setLayoutManager(layoutManager);

        List<Sermon> dataList = new ArrayList<>();
        dataList.add(new Sermon());
        dataList.add(new Sermon("UMEZALIWA KUSHINDA","Mwanza NVC Semina"));
        dataList.add(new Sermon("UMEZALIWA KUSHINDA","Mwanza NVC Semina"));
        dataList.add(new Sermon("UMEZALIWA KUSHINDA","Mwanza NVC Semina"));
        dataList.add(new Sermon("UMEZALIWA KUSHINDA","Mwanza NVC Semina"));
        dataList.add(new Sermon("UMEZALIWA KUSHINDA","Mwanza NVC Semina"));

        FrontRecyclerAdapter adapter = new FrontRecyclerAdapter(dataList);
        frontRecyclerview.setAdapter(adapter);

        return rootView;
    }

    public void setUpView(View v){
        frontRecyclerview   = (RecyclerView) v.findViewById(R.id.recycler_view);
        ibadaTitle  = (TextView) v.findViewById(R.id.ibada_za_jumapili);
        ibadaTitle.setTypeface(MainActivity.Rosario_Regular);
    }

}

