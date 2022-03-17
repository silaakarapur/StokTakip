package com.example.stoktakip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter<listAdapter.MyViewHolder> {
    private final Context context;
    ArrayList<String> urunid, urunadi, urunkodi;

    listAdapter(Context context,
                ArrayList<String> urunid,
                ArrayList<String> urunadi,
                ArrayList<String> urunkodi) {
        this.context = context;
        this.urunid = urunid;
        this.urunadi = urunadi;
        this.urunkodi = urunkodi;

    }

    @NonNull
    @Override
    public listAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listAdapter.MyViewHolder holder, int position) {
        holder.ürün_id_txt.setText(String.valueOf(urunid.get(position)));
        holder.ürün_adi_txt.setText(String.valueOf(urunadi.get(position)));
        holder.ürün_kodi_txt.setText(String.valueOf(urunkodi.get(position)));
    }

    @Override
    public int getItemCount() {
        return urunadi.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ürün_id_txt, ürün_adi_txt, ürün_kodi_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ürün_id_txt = itemView.findViewById(R.id.id_text);
            ürün_adi_txt = itemView.findViewById(R.id.ürün_adi);
            ürün_kodi_txt = itemView.findViewById(R.id.ürünkodi);
        }
    }
}
