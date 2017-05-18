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
import apps.soma.com.fblc.adapter.FrontRecyclerAdapter;
import apps.soma.com.fblc.adapter.MaktabaRecyclerAdapter;
import apps.soma.com.fblc.datamodels.MaktabaRow;
import apps.soma.com.fblc.datamodels.Sermon;

/**
 * Created by somaapps on 5/1/17.
 */

public class MaktabaFragment extends Fragment {

    RecyclerView maktabaRecyclerView;

    public MaktabaFragment() {
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
        rootView    = inflater.inflate(R.layout.fragment_maktaba, container, false);

        setUpView(rootView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MaktabaFragment.this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        maktabaRecyclerView.setLayoutManager(layoutManager);

        List<MaktabaRow> dataList = new ArrayList<>();
        dataList.add(new MaktabaRow(4));
        dataList.add(new MaktabaRow(2));
        dataList.add(new MaktabaRow(3));
        dataList.add(new MaktabaRow(2));
        dataList.add(new MaktabaRow(4));

        MaktabaRecyclerAdapter adapter = new MaktabaRecyclerAdapter(dataList, MaktabaFragment.this.getContext());
        maktabaRecyclerView.setAdapter(adapter);

        return rootView;
    }

    public void setUpView(View v){
        maktabaRecyclerView = (RecyclerView) v.findViewById(R.id.maktaba_recycler_view);
    }

}