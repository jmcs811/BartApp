package com.jcaseydev.bart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jcaseydev.bart.Model2.Station;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

  private List<Station> datalist;
  private Context context;

  public CustomAdapter(Context context, List<Station> datalist) {
    this.context = context;
    this.datalist = datalist;
  }

  @NonNull
  @Override
  public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View view = layoutInflater.inflate(R.layout.list_item_station, parent, false);
    return new CustomViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
    String city = datalist.get(position).getCity();
    String zipCode = datalist.get(position).getZipcode();
    holder.stationName.setText(datalist.get(position).getName());
    holder.stationCity.setText(city + ", CA " + zipCode);
  }

  @Override
  public int getItemCount() {
    return datalist.size();
  }

  class CustomViewHolder  extends RecyclerView.ViewHolder {

    public final View mView;
    TextView stationName;
    TextView stationCity;

    public CustomViewHolder(@NonNull View itemView) {
      super(itemView);

      mView = itemView;
      stationName = mView.findViewById(R.id.station_name);
      stationCity = mView.findViewById(R.id.station_city);
    }
  }



}
