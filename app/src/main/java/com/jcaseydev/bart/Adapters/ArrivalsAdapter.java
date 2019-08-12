package com.jcaseydev.bart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jcaseydev.bart.Model2.Arrivals.Estimate;
import com.jcaseydev.bart.Model2.Arrivals.Etd;
import com.jcaseydev.bart.R;
import java.util.List;

public class ArrivalsAdapter extends RecyclerView.Adapter<ArrivalsAdapter.CustomViewHolder> {

  private List<Etd> stations;
  private Context context;

  public ArrivalsAdapter(Context context, List<Etd> stations) {
    this.context = context;
    this.stations = stations;

  }

  @NonNull
  @Override
  public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View view = layoutInflater.inflate(R.layout.list_item_arrivals, parent, false);
    return new CustomViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
    List<Estimate> stationArrivals = stations.get(position).getEstimate();
    String minutes = stationArrivals.get(0).getMinutes();
    String platform = stationArrivals.get(0).getPlatform();
    String length = stationArrivals.get(0).getLength();

    holder.stationName.setText(stations.get(position).getDestination());
    holder.minutes.setText(context.getString(R.string.arrivals_minutes, minutes));
    holder.platform.setText(context.getString(R.string.arrivals_platform, platform));
    holder.length.setText(context.getString(R.string.arrivals_length, length));
  }

  @Override
  public int getItemCount() {
    return stations.size();
  }

  class CustomViewHolder extends RecyclerView.ViewHolder {
    public final View mView;

    TextView stationName;
    TextView minutes;
    TextView platform;
    TextView length;

    public CustomViewHolder(@NonNull View itemView) {
      super(itemView);
      mView = itemView;

      stationName = mView.findViewById(R.id.destination_text_view);
      minutes = mView.findViewById(R.id.minutes_text_view);
      platform = mView.findViewById(R.id.platform_text_view);
      length = mView.findViewById(R.id.train_length_text_view);
    }
  }

}
