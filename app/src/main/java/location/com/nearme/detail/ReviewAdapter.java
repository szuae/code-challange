package location.com.nearme.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import location.com.nearme.R;
import location.com.nearme.browse.ListContract;
import location.com.nearme.repository.NearbyPlacesDetailResponseDTO;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.viewHolder> {

    List<NearbyPlacesDetailResponseDTO.Result.Reviews> data = new ArrayList<NearbyPlacesDetailResponseDTO.Result.Reviews>();
    Context context;
    DetailContract.View fragmentView;
    private Unbinder unbinder;


    public ReviewAdapter(Context context, DetailContract.View view) {
        this.context = context;
        this.fragmentView = view;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_item_layout, parent, false);

        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<NearbyPlacesDetailResponseDTO.Result.Reviews> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position, List<Object> payloads) {
        holder.name.setText(data.get(position).getAuthor_name());
        holder.time.setText(data.get(position).getRelative_time_description());
        holder.content.setText(data.get(position).getText());
        holder.ratingBar.setRating(data.get(position).getRating());

    }

    static class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.review_name)
        TextView name;
        @BindView(R.id.review_time)
        TextView time;
        @BindView(R.id.review_content)
        TextView content;
        @BindView(R.id.review_ratingBar)
        RatingBar ratingBar;

        public viewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onViewAttachedToWindow(viewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(viewHolder holder) {
        super.onViewDetachedFromWindow(holder);
//        unbinder.unbind();
    }
}
