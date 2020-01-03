package com.doan.DoAnAndroid.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doan.DoAnAndroid.ManHinhTroChoi;
import com.doan.DoAnAndroid.R;
import com.doan.DoAnAndroid.Class.clsLinhVuc;

import java.util.ArrayList;

public class LinhVucAdapter extends RecyclerView.Adapter<LinhVucAdapter.LinhVucViewHolder> {
    private ArrayList<clsLinhVuc> mListLinhVuc;
    private LayoutInflater inflater;
    private Context context;

    public LinhVucAdapter(Context context, ArrayList<clsLinhVuc> listLinhVuc) {
        this.inflater = LayoutInflater.from(context);
        this.mListLinhVuc = listLinhVuc;
        this.context = context;
    }
    @NonNull
    @Override
    public LinhVucAdapter.LinhVucViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.linh_vuc_item, parent, false);
        return new LinhVucViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull LinhVucAdapter.LinhVucViewHolder holder, int position) {
        clsLinhVuc linhVuc = this.mListLinhVuc.get(position);
        holder.txtLinhVuc.setText(linhVuc.getTenLinhVuc());
    }

    @Override
    public int getItemCount() {
        return this.mListLinhVuc.size();
    }

    public class LinhVucViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtLinhVuc;
        private LinhVucAdapter adapter;
        public LinhVucViewHolder(@NonNull View itemView, LinhVucAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.txtLinhVuc = itemView.findViewById(R.id.txtTenLinhVuc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           Intent intent = new Intent(context, ManHinhTroChoi.class);
           context.startActivity(intent);
        }
    }
}
