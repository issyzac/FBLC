package apps.soma.com.fblc.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

import apps.soma.com.fblc.R;
import apps.soma.com.fblc.datamodels.OrderStatus;
import apps.soma.com.fblc.datamodels.Orientation;
import apps.soma.com.fblc.datamodels.TimeLineModel;
import apps.soma.com.fblc.utils.DateTimeUtils;
import apps.soma.com.fblc.utils.VectorDrawableUtils;
import apps.soma.com.fblc.viewholder.TimeLineViewHolder;

/**
 * Created by issy on 3/21/17.
 */

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

    private List<TimeLineModel> mFeedList;
    private Context mContext;
    private Orientation mOrientation;
    private boolean mWithLinePadding;
    private LayoutInflater mLayoutInflater;

    public TimeLineAdapter(List<TimeLineModel> feedList, Orientation orientation, boolean withLinePadding, Context ctx) {
        mFeedList = feedList;
        Log.d("BOYCE", "Size at the inner adapter is "+mFeedList.size());
        mOrientation = orientation;
        mWithLinePadding = withLinePadding;
        mContext = ctx;
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("BOYCE", "View Type is "+TimelineView.getTimeLineViewType(position,getItemCount()));
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        Log.d("BOYCE", "at onCreateViewHolder");

        if(mOrientation == Orientation.HORIZONTAL) {
            Log.d("BOYCE", "Horizontal");
            view = mLayoutInflater.inflate(mWithLinePadding ? R.layout.item_timeline_horizontal_line_padding : R.layout.item_timeline_horizontal, parent, false);
        } else {
            Log.d("BOYCE", "Vertical");
            view = mLayoutInflater.inflate(mWithLinePadding ? R.layout.item_timeline_line_padding : R.layout.item_timeline, parent, false);
        }

        Log.d("BOYCE", "Is View Null?? : "+(view == null));
        Log.d("BOYCE", "View Type is "+viewType);

        return new TimeLineViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {

        TimeLineModel timeLineModel = mFeedList.get(position);
        Log.d("BOYCE", "item is : "+timeLineModel.getMessage());

        if(timeLineModel.getStatus() == OrderStatus.INACTIVE) {
            holder.mTimelineView.setMarker(VectorDrawableUtils.getDrawable(mContext, R.drawable.ic_marker_inactive, android.R.color.darker_gray));
        } else if(timeLineModel.getStatus() == OrderStatus.ACTIVE) {
            holder.mTimelineView.setMarker(VectorDrawableUtils.getDrawable(mContext, R.drawable.ic_marker_active, R.color.main_color));
        } else {
            holder.mTimelineView.setMarker(ContextCompat.getDrawable(mContext, R.drawable.ic_marker), ContextCompat.getColor(mContext, R.color.main_color));
        }

        if(!timeLineModel.getDate().isEmpty()) {
            holder.mDate.setVisibility(View.VISIBLE);
            holder.mDate.setText(DateTimeUtils.parseDateTime(timeLineModel.getDate(), "yyyy-MM-dd HH:mm", "hh:mm a, dd-MMM-yyyy"));
        }
        else
            holder.mDate.setVisibility(View.GONE);

        holder.mMessage.setText(timeLineModel.getMessage());
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }

}