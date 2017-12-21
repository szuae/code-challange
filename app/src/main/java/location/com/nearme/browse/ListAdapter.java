package location.com.nearme.browse;

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
import location.com.nearme.model.NearbyPlacesObject;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.viewHolder> {

    List<NearbyPlacesObject> data = new ArrayList<NearbyPlacesObject>();
    Context context;
    ListContract.View fragmentView;
    private Unbinder unbinder;


    public ListAdapter(Context context, ListContract.View view) {
        this.context = context;
        this.fragmentView = view;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);

        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<NearbyPlacesObject> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position, List<Object> payloads) {
        holder.name.setText(data.get(position).getName());
        holder.address.setText(data.get(position).getAddress());
        holder.ratingBar.setRating(data.get(position).getRating());
        if (data.get(position).isOpen_now()) {
            holder.working.setText(context.getResources().getString(R.string.open_label));
            holder.working.setTextColor(context.getResources().getColor(R.color.open_text_color));
        } else {
            holder.working.setText(context.getResources().getString(R.string.close_label));
            holder.working.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        }
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentView.onItemClicked(data.get(position));
            }
        });
    }

    static class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_name)
        TextView name;
        @BindView(R.id.list_address)
        TextView address;
        @BindView(R.id.list_working_hour)
        TextView working;
        @BindView(R.id.list_ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.list_item)
        View view;

        public viewHolder(View itemView) {
            super(itemView);

        }
    }

    @Override
    public void onViewAttachedToWindow(viewHolder holder) {
        super.onViewAttachedToWindow(holder);
        unbinder = ButterKnife.bind(this, holder.itemView);
    }

    @Override
    public void onViewDetachedFromWindow(viewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        unbinder.unbind();
    }
}
