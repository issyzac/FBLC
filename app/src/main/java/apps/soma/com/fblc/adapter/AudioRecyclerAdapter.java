package apps.soma.com.fblc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import apps.soma.com.fblc.MainActivity;
import apps.soma.com.fblc.R;
import apps.soma.com.fblc.datamodels.Sermon;

import static apps.soma.com.fblc.utils.Constants.VIEW_TYPE_HEADER;
import static apps.soma.com.fblc.utils.Constants.VIEW_TYPE_ITEMS;

/**
 * Created by somaapps on 5/2/17.
 */

public class AudioRecyclerAdapter  extends RecyclerView.Adapter <RecyclerView.ViewHolder> {

    private List<Sermon> items;

    public Context context;

    public AudioRecyclerAdapter(Context ctx){
//        if (datamodel == null){
//            throw new IllegalArgumentException(
//                    "Data cannot be null"
//            );
//        }
//        this.items = datamodel;
        this.context    = ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View itemView = null;
        if (viewType == VIEW_TYPE_HEADER){
            itemView = LayoutInflater
                    .from(viewGroup.getContext())
                    .inflate(R.layout.fragment_front_grid_header, viewGroup, false);
            return new AudioRecyclerAdapter.ListViewHeaderViewHolder(itemView);
        }else if (viewType == VIEW_TYPE_ITEMS){
            itemView = LayoutInflater
                    .from(viewGroup.getContext())
                    .inflate(R.layout.maktaba_recycler_audio_item, viewGroup, false);
            return new AudioRecyclerAdapter.ListViewItemViewHolder(itemView);
        }

        throw new RuntimeException("There is no type that matches the type "+viewType+" make sure you are using the types correctly");

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int itemPosition){

        if (viewHolder instanceof AudioRecyclerAdapter.ListViewItemViewHolder){
//            Sermon sermon = items.get(itemPosition-1);
            AudioRecyclerAdapter.ListViewItemViewHolder holder = (AudioRecyclerAdapter.ListViewItemViewHolder) viewHolder;
//            holder.title.setText(sermon.getSermon_title());
        }else if (viewHolder instanceof AudioRecyclerAdapter.ListViewHeaderViewHolder){

        }

    }

    @Override
    public int getItemCount(){
//        return items.size()+1;
        return 7;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return VIEW_TYPE_HEADER;

        return VIEW_TYPE_ITEMS;
    }

    private boolean isPositionHeader(int position){
        return position == 0;
    }

    private Sermon getItem(int position){
        return items.get(position-1);
    }

    class ListViewItemViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView subTitle;

        public ListViewItemViewHolder(View itemView){
            super(itemView);
            title       = (TextView) itemView.findViewById(R.id.sermon_title);
        }

    }

    class ListViewHeaderViewHolder extends RecyclerView.ViewHolder{

        TextView mTitle;

        public ListViewHeaderViewHolder(View itemView){
            super(itemView);
            mTitle  = (TextView) itemView.findViewById(R.id.m_title);
            mTitle  .setTextColor(context.getResources().getColor(R.color.white));
            mTitle  .setTypeface(MainActivity.Rosario_Bold);
        }

    }

}