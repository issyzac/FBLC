package apps.soma.com.fblc.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import apps.soma.com.fblc.MainActivity;
import apps.soma.com.fblc.R;
import apps.soma.com.fblc.datamodels.MaktabaRow;
import apps.soma.com.fblc.datamodels.Orientation;
import apps.soma.com.fblc.fragments.FrontFragment;

import static apps.soma.com.fblc.utils.Constants.VIEW_TYPE_ARTICLES;
import static apps.soma.com.fblc.utils.Constants.VIEW_TYPE_AUDIO;
import static apps.soma.com.fblc.utils.Constants.VIEW_TYPE_VIDEO;

/**
 * Created by somaapps on 5/1/17.
 */

public class MaktabaRecyclerAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> {

    private List<MaktabaRow> items;

    public Context context;

    public MaktabaRecyclerAdapter(List<MaktabaRow> datamodel, Context ctx){
        if (datamodel == null){
            throw new IllegalArgumentException(
                    "Data cannot be null"
            );
        }
        this.context = ctx;
        this.items = datamodel;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View itemView = null;
        if (viewType == VIEW_TYPE_AUDIO){
            itemView = LayoutInflater
                    .from(viewGroup.getContext())
                    .inflate(R.layout.fragment_maktaba_list_audio, viewGroup, false);
            return new MaktabaRecyclerAdapter.ListViewAudioViewHolder(itemView);
        }else if (viewType == VIEW_TYPE_VIDEO){
            itemView = LayoutInflater
                    .from(viewGroup.getContext())
                    .inflate(R.layout.fragment_maktaba_list_video, viewGroup, false);
            return new MaktabaRecyclerAdapter.ListViewVideoViewHolder(itemView);
        }else if (viewType == VIEW_TYPE_ARTICLES){
            itemView = LayoutInflater
                    .from(viewGroup.getContext())
                    .inflate(R.layout.fragment_maktaba_list_article, viewGroup, false);
            return new MaktabaRecyclerAdapter.ListViewArticleViewHolder(itemView);
        }

        throw new RuntimeException("There is no type that matches the type "+viewType+" make sure you are using the types correctly");

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int itemPosition){

        if (viewHolder instanceof MaktabaRecyclerAdapter.ListViewAudioViewHolder){
//            MaktabaRow row = items.get(itemPosition-1);
            MaktabaRecyclerAdapter.ListViewAudioViewHolder holder = (MaktabaRecyclerAdapter.ListViewAudioViewHolder) viewHolder;

            //Create an adapter and attach to the audio viewpager
            AudioRecyclerAdapter adapter = new AudioRecyclerAdapter(context);
            holder.audioRecyclerView.setAdapter(adapter);


        }else if (viewHolder instanceof MaktabaRecyclerAdapter.ListViewVideoViewHolder){

            MaktabaRecyclerAdapter.ListViewVideoViewHolder holder = (MaktabaRecyclerAdapter.ListViewVideoViewHolder) viewHolder;

            //Create an adapter and attach to the video viewpager
            VideoRecyclerAdapter adapter = new VideoRecyclerAdapter();
            holder.videoRecyclerView.setAdapter(adapter);


        }else if (viewHolder instanceof MaktabaRecyclerAdapter.ListViewArticleViewHolder){

            MaktabaRecyclerAdapter.ListViewArticleViewHolder holder = (MaktabaRecyclerAdapter.ListViewArticleViewHolder) viewHolder;

            //Create an adapter and attach to the article viewpager
            ArticleRecyclerAdapter adapter = new ArticleRecyclerAdapter(context);
            holder.articlesRecyclerView.setAdapter(adapter);

        }

    }

    @Override
    public int getItemCount(){
        Log.d("BASSEY", "size is : "+items.size());
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("BASSEY", "position is : "+position);
        if (items.get(position).getViewType() == VIEW_TYPE_AUDIO){
            return VIEW_TYPE_AUDIO;
        }else if (items.get(position).getViewType() == VIEW_TYPE_VIDEO){
            return VIEW_TYPE_VIDEO;
        }else {
            return VIEW_TYPE_ARTICLES;
        }
    }

    private MaktabaRow getItem(int position){
        Log.d("BASSEY", "position at get item is : "+position);
        return items.get(position-1);
    }

    class ListViewAudioViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        RecyclerView audioRecyclerView;

        public ListViewAudioViewHolder(View itemView){
            super(itemView);
            title       = (TextView) itemView.findViewById(R.id.audio_shared);
            audioRecyclerView   = (RecyclerView) itemView.findViewById(R.id.audio_recycler_view);
            audioRecyclerView   .setFocusable(false);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            audioRecyclerView.setLayoutManager(layoutManager);

        }

    }

    class ListViewVideoViewHolder extends RecyclerView.ViewHolder{

        TextView mTitle, videoMidTitle;
        RecyclerView videoRecyclerView;

        public ListViewVideoViewHolder(View itemView){
            super(itemView);
            mTitle  = (TextView) itemView.findViewById(R.id.videos_shared);
            mTitle  .setTypeface(MainActivity.Roboto_Regular);

            videoMidTitle  = (TextView) itemView.findViewById(R.id.videos_mid_title);
            videoMidTitle  .setTypeface(MainActivity.Roboto_Regular);

            videoRecyclerView   = (RecyclerView) itemView.findViewById(R.id.videos_recycler_view);
            videoRecyclerView   .setFocusable(false);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            videoRecyclerView.setLayoutManager(layoutManager);
        }

    }

    class ListViewArticleViewHolder extends RecyclerView.ViewHolder{

        TextView mTitle, articleMidTitle;
        RecyclerView articlesRecyclerView;

        public ListViewArticleViewHolder(View itemView){
            super(itemView);
            mTitle  = (TextView) itemView.findViewById(R.id.articles_shared);
            mTitle  .setTypeface(MainActivity.Roboto_Regular);

            articleMidTitle = (TextView) itemView.findViewById(R.id.article_mid_title);
            articleMidTitle .setTypeface(MainActivity.Roboto_Light);

            articlesRecyclerView    = (RecyclerView) itemView.findViewById(R.id.articles_recycler_view);
            articlesRecyclerView    .setFocusable(false);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            articlesRecyclerView.setLayoutManager(layoutManager);

        }

    }

}
