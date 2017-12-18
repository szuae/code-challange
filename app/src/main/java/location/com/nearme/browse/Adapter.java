package location.com.nearme.browse;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import location.com.nearme.R;
import location.com.nearme.model.NearbyPlacesObject;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    List<NearbyPlacesObject> data = new ArrayList<NearbyPlacesObject>();
    Context context;
    ListContract.View fragmentView;

    public Adapter(Context context, ListContract.View view) {
        this.context = context;
        this.fragmentView = view;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_layout_item, parent, false);

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
//        holder.view.setCardBackgroundColor(context.getResources().getColor(R.color.card_background_color));
        holder.title.setText(data.get(position).getName());
        holder.sub_title.setText(data.get(position).getType());
//        holder.icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.groceries));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentView.onItemClicked(data.get(position));
            }
        });
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title;
        CardView view;
        TextView sub_title;
        ImageView icon;

        public viewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            sub_title = itemView.findViewById(R.id.sub_title);
            view = itemView.findViewById(R.id.card_view);
            icon = itemView.findViewById(R.id.logo);
        }
    }
}
