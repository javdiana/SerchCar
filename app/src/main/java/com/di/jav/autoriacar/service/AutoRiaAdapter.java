package com.di.jav.autoriacar.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.di.jav.autoriacar.R;
import com.di.jav.autoriacar.model.DataFromCar;
import com.di.jav.autoriacar.service.dbservice.DBHelperCar;
import com.squareup.picasso.Picasso;

import java.util.List;

import lombok.Setter;

@Setter
public class AutoRiaAdapter extends RecyclerView.Adapter<AutoRiaAdapter.ViewHolder> {
    private List<DataFromCar> cars;
    private Context context;
    private SQLiteDatabase database;
    private DBHelperCar dbHelperCar;

    public AutoRiaAdapter(List<DataFromCar> cars, Context context, SQLiteDatabase database, DBHelperCar dbHelperCar) {
        setCars(cars);
        setContext(context);
        setDatabase(database);
        setDbHelperCar(dbHelperCar);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataFromCar c = cars.get(position);
        Picasso.with(context).load(c.getPhotoData()).into(holder.imageAuto);
        holder.nameAuto.setText(String.format("%s %s, %s", c.getMarkName(), c.getModelName(), c.getYear()));
        holder.costAuto.setText(c.getUSD()+"$");
        holder.nameSite.setText(c.getOriginSite());
    }

    @Override
    public int getItemCount() {
        if (cars == null)
            return 0;
        return cars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageAuto;
        TextView nameAuto;
        TextView costAuto;
        TextView nameSite;

        public ViewHolder(View itemView) {
            super(itemView);
            imageAuto = itemView.findViewById(R.id.image_auto);
            nameAuto = itemView.findViewById(R.id.name_auto);
            costAuto = itemView.findViewById(R.id.cost_auto);
            nameSite = itemView.findViewById(R.id.name_site);
        }
    }
}
