package apps.soma.com.fblc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import apps.soma.com.fblc.R;
import apps.soma.com.fblc.adapter.RatibaRecyclerAdapter;
import apps.soma.com.fblc.datamodels.Sermon;
import apps.soma.com.fblc.datamodels.YearEvents;

/**
 * Created by issy on 4/26/17.
 */

public class RatibaFragment extends Fragment {

    RecyclerView recyclerView;

    public RatibaFragment() {
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
        rootView    = inflater.inflate(R.layout.fragment_ratiba, container, false);

        setUpView(rootView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(RatibaFragment.this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<YearEvents> dataList = new ArrayList<>();
        dataList.add(new YearEvents("", "MAY 2017"));
        dataList.add(new YearEvents("", "JUNE 2017"));

        RatibaRecyclerAdapter adapter = new RatibaRecyclerAdapter(dataList, RatibaFragment.this.getActivity());
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    public void setUpView(View v){
        recyclerView    = (RecyclerView) v.findViewById(R.id.ratiba_recycler_view);
     }

}