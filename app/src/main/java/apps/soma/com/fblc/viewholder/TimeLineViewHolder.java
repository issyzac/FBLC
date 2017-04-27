package apps.soma.com.fblc.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;

import apps.soma.com.fblc.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by issy on 3/21/17.
 */

public class TimeLineViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_timeline_date)
    public TextView mDate;
    @BindView(R.id.text_timeline_title)
    public TextView mMessage;
    @BindView(R.id.time_marker)
    public TimelineView mTimelineView;

    public TimeLineViewHolder(View itemView, int viewType) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        mTimelineView.initLine(viewType);

    }
}
