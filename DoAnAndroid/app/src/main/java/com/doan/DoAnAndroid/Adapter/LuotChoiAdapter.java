package com.doan.DoAnAndroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doan.DoAnAndroid.Class.LuotChoi;
import com.doan.DoAnAndroid.R;

import java.util.ArrayList;

public class LuotChoiAdapter extends RecyclerView.Adapter<LuotChoiAdapter.LuotChoiViewHolder> {
    private  LayoutInflater inflater;
    private  ArrayList<LuotChoi> mListLuotChoi;
    private  Context context;

    public LuotChoiAdapter(Context context, ArrayList<LuotChoi> mListLuotChoi) {
        this.inflater = LayoutInflater.from(context);
        this.mListLuotChoi = mListLuotChoi;
        this.context = context;
    }
    @NonNull
    @Override
    public LuotChoiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.lich_su_choi_item,parent,false);
        return new LuotChoiViewHolder(item,this);
    }

    @Override
    public void onBindViewHolder(@NonNull LuotChoiViewHolder holder, int position) {
        LuotChoi luotChoi = this.mListLuotChoi.get(position);

        holder.vitri.setText(position+1+"");
        holder.so_cau.setText(luotChoi.getSoCau()+"");//nhớ có dấu khoảng trắng
        holder.diem.setText(luotChoi.getSoDiem()+"");
        holder.dateCredte.setText(luotChoi.getDateCreate());
    }

    @Override
    public int getItemCount() {
        return this.mListLuotChoi.size();
    }

    public class LuotChoiViewHolder extends RecyclerView.ViewHolder {
        private  LuotChoiAdapter luotChoiAdapter;
        private  TextView so_cau;
        private  TextView diem;
        private  TextView vitri;
        private  TextView dateCredte;

        public LuotChoiViewHolder(@NonNull View itemView, LuotChoiAdapter luotChoiAdapter) {
            super(itemView);
            this.luotChoiAdapter = luotChoiAdapter;
            this.vitri = itemView.findViewById(R.id.txt_sttlichsu);
            this.so_cau = itemView.findViewById(R.id.txtSoCau);
            this.diem = itemView.findViewById(R.id.txtSoDiem);
            this.dateCredte = itemView.findViewById(R.id.txtNgayChoi);
        }
    }
}
