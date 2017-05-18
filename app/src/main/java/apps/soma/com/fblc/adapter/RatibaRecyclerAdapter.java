package apps.soma.com.fblc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import apps.soma.com.fblc.MainActivity;
import apps.soma.com.fblc.R;
import apps.soma.com.fblc.datamodels.OrderStatus;
import apps.soma.com.fblc.datamodels.Orientation;
import apps.soma.com.fblc.datamodels.Sermon;
import apps.soma.com.fblc.datamodels.TimeLineModel;
import apps.soma.com.fblc.datamodels.YearEvents;

import static apps.soma.com.fblc.utils.Constants.VIEW_TYPE_HEADER;
import static apps.soma.com.fblc.utils.Constants.VIEW_TYPE_ITEMS;

/**
 * Created by issy on 4/26/17.
 */

public class RatibaRecyclerAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> {

    List<YearEvents> items;

    private Orientation mOrientation;
    private boolean mWithLinePadding;
    private Context context;

    public RatibaRecyclerAdapter(List<YearEvents> datamodel, Context ctx){
        if (datamodel == null){
            throw new IllegalArgumentException(
                    "Data cannot be null"
            );
        }
        this.items = datamodel;
        this.context = ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View itemView = null;
        if (viewType == VIEW_TYPE_HEADER){
            itemView = LayoutInflater
                    .from(viewGroup.getContext())
                    .inflate(
                            R.layout.ratiba_recycler_header, viewGroup, false);
            return new RatibaRecyclerAdapter.ListViewHeaderViewHolder(itemView);
        }else if (viewType == VIEW_TYPE_ITEMS){
            itemView = LayoutInflater
                    .from(viewGroup.getContext())
                    .inflate(R.layout.ratiba_recycler_item, viewGroup, false);
            return new RatibaRecyclerAdapter.ListViewItemViewHolder(itemView);
        }

        throw new RuntimeException("There is no type that matches the type "+viewType+" make sure you are using the types correctly");

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int itemPosition){

        if (viewHolder instanceof RatibaRecyclerAdapter.ListViewItemViewHolder){
            Log.d("BOYCE", "Item Position is "+itemPosition);

            YearEvents event = items.get(itemPosition-1);
            final RatibaRecyclerAdapter.ListViewItemViewHolder holder = (RatibaRecyclerAdapter.ListViewItemViewHolder) viewHolder;

            List<TimeLineModel> dataList = new ArrayList<>();
            dataList = setDataListItems();

            Log.d("BOYCE", "Data list size is "+dataList.size());

            Intent intent = ((Activity) context).getIntent();

            mOrientation = (Orientation) intent.getSerializableExtra(MainActivity.EXTRA_ORIENTATION);
            mWithLinePadding = intent.getBooleanExtra(MainActivity.EXTRA_WITH_LINE_PADDING, false);

            TimeLineAdapter mTimeLineAdapter = new TimeLineAdapter(dataList, mOrientation, mWithLinePadding, context);
            holder.recyclerView.setAdapter(mTimeLineAdapter);

            holder.setItem(event, itemPosition);

        }else if (viewHolder instanceof RatibaRecyclerAdapter.ListViewHeaderViewHolder){

        }

    }

    @Override
    public int getItemCount(){
        return items.size()+1;
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

    private YearEvents getItem(int position){
        return items.get(position-1);
    }

    private List<TimeLineModel> setDataListItems(){

        List<TimeLineModel> mDataList = new ArrayList<>();

        mDataList.add(new TimeLineModel("Mkutano wa Injili Iringa", "", OrderStatus.INACTIVE));
        mDataList.add(new TimeLineModel("Semina ya Ndoa, Dodoma", "2017-05-12 08:00", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("Ibada ya vijana Kawe", "2017-05-11 21:00", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("Tamasha la Uimbaji Ubungo", "2017-05-11 18:00", OrderStatus.COMPLETED));
//        mDataList.add(new TimeLineModel("Item is packed and will dispatch soon", "2017-02-11 09:30", OrderStatus.COMPLETED));
//        mDataList.add(new TimeLineModel("Order is being readied for dispatch", "2017-02-11 08:00", OrderStatus.COMPLETED));
//        mDataList.add(new TimeLineModel("Order processing initiated", "2017-02-10 15:00", OrderStatus.COMPLETED));
//        mDataList.add(new TimeLineModel("Order confirmed by seller", "2017-02-10 14:30", OrderStatus.COMPLETED));
//        mDataList.add(new TimeLineModel("Order placed successfully", "2017-02-10 14:00", OrderStatus.COMPLETED));

        return mDataList;

    }

    class ListViewItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ExpandableRelativeLayout expandableRelativeLayout;
        LinearLayout listItemHeaderRelativeLayout;
        View topLineView, bottomLineView;
        TextView monthTitle;
        RecyclerView recyclerView;

        private YearEvents item;
        int currentPosition = 0;

        public ListViewItemViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            expandableRelativeLayout    = (ExpandableRelativeLayout) itemView.findViewById(R.id.expandableLayout_calendar_item);

            listItemHeaderRelativeLayout= (LinearLayout) itemView.findViewById(R.id.list_item_header_rl);

            topLineView = (View) itemView.findViewById(R.id.top_line_view);
            bottomLineView  = (View) itemView.findViewById(R.id.bottom_line_view);

            monthTitle  = (TextView) itemView.findViewById(R.id.month_title);
            monthTitle  .setTypeface(MainActivity.Roboto_BoldCondensed);

            recyclerView    = (RecyclerView) itemView.findViewById(R.id.recyclerView);
            recyclerView.setFocusable(false);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(getLinearLayoutManager());

        }

        @Override
        public void onClick(View view) {
            Log.d("RATIBAADAPTER", "On Click "+ getPosition() + " " + item.getEventTitle());
            if (expandableRelativeLayout.isExpanded()){
                expandableRelativeLayout.collapse();
            }else {
                expandableRelativeLayout.expand();
            }
        }

        public void setItem(YearEvents dataItem, int position){

            this.item = dataItem;
            this.currentPosition = position;

            if (currentPosition == 1){
                topLineView.setVisibility(View.GONE);
            }

            if (currentPosition == getItemCount()-1){
                bottomLineView.setVisibility(View.GONE);
            }

            monthTitle.setText(item.getMonthName());

        }

        private LinearLayoutManager getLinearLayoutManager() {
            if (mOrientation == Orientation.HORIZONTAL) {
                return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            } else {
                return new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            }
        }

    }

    class ListViewHeaderViewHolder extends RecyclerView.ViewHolder{

        TextView mTitle, dateOfEvent, placeOfEvent;

        public ListViewHeaderViewHolder(View itemView){
            super(itemView);
            mTitle  = (TextView) itemView.findViewById(R.id.header_event_title);
            mTitle  .setTypeface(MainActivity.Roboto_BoldCondensed);

            dateOfEvent = (TextView) itemView.findViewById(R.id.header_date_of_event);
            dateOfEvent .setTypeface(MainActivity.Roboto_Light);
            placeOfEvent    = (TextView) itemView.findViewById(R.id.header_place_of_event);
            placeOfEvent    .setTypeface(MainActivity.Roboto_Light);

        }

    }

}
