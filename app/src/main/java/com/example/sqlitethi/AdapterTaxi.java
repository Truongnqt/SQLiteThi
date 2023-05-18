package com.example.sqlitethi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.sqlitethi.ModelTaxi;
import com.example.sqlitethi.R;

import java.util.ArrayList;

public class AdapterTaxi extends BaseAdapter {
    private ArrayList<ModelTaxi> ListTaxi;
    private Activity context;
    private LayoutInflater inflater;

    public AdapterTaxi(ArrayList<ModelTaxi> data, Activity context) {
        ListTaxi = data;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ListTaxi.size();
    }

    @Override
    public Object getItem(int i) {
        return ListTaxi.get(i);
    }

    @Override
    public long getItemId(int i) {
        return ListTaxi.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            view = inflater.inflate(R.layout.item_taxi, null);
            holder = new ViewHolder();
            holder.soxe = view.findViewById(R.id.Soxe);
            holder.quangduong = view.findViewById(R.id.Quangduong);
            holder.gia = view.findViewById(R.id.Gia);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        ModelTaxi taxi = ListTaxi.get(i);
        holder.soxe.setText(taxi.getSoxe());
        holder.quangduong.setText("Quãng đường(Km) : " + taxi.getQuangduong());
        holder.gia.setText("" + taxi.getGia());
        // set sự kiện long press cho item

        return view;
    }


    static class ViewHolder {
        TextView soxe;
        TextView quangduong;
        TextView gia;
    }
}
