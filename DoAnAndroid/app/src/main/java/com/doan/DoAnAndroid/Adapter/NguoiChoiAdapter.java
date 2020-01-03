package com.doan.DoAnAndroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doan.DoAnAndroid.R;
import com.doan.DoAnAndroid.Class.clsNguoiChoi;

import java.util.ArrayList;

public class NguoiChoiAdapter extends RecyclerView.Adapter<NguoiChoiAdapter.NguoiChoiViewHolder> {
    private ArrayList<clsNguoiChoi> arrayListNguoiChoi;
    private LayoutInflater inflater;
    private Context context;
    public NguoiChoiAdapter(Context context,ArrayList<clsNguoiChoi> arrayListNguoiChoi){
    this.inflater=LayoutInflater.from(context);
    this.arrayListNguoiChoi=arrayListNguoiChoi;
    this.context=context;
    }
    @NonNull
    @Override
    public NguoiChoiAdapter.NguoiChoiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =this.inflater.inflate(R.layout.bang_xep_hang,parent,false);
        return  new NguoiChoiViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull NguoiChoiAdapter.NguoiChoiViewHolder holder, int position) {
        clsNguoiChoi nguoiChoi = arrayListNguoiChoi.get(position);
        holder.nguoiChoi.setText(nguoiChoi.getTenNguoiChoi());
        holder.diemSo.setText(nguoiChoi.getDiemSo()+"");
    }

    @Override
    public int getItemCount() {
        return arrayListNguoiChoi.size();
    }

    public class NguoiChoiViewHolder extends RecyclerView.ViewHolder {
        private TextView nguoiChoi;
        private  TextView diemSo;
        private NguoiChoiAdapter adapter;
        public NguoiChoiViewHolder(@NonNull View itemView, NguoiChoiAdapter nguoiChoiAdapter) {
            super(itemView);
            this.nguoiChoi=itemView.findViewById(R.id.txtTenNguoiChoi);
            this.diemSo=itemView.findViewById(R.id.txtDiemSoNguoiChoi);
            this.adapter=nguoiChoiAdapter;
        }
    }
}
