package com.doan.DoAnAndroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CreditAdapter extends RecyclerView.Adapter<CreditAdapter.CreditViewHolder> {
    private ArrayList<Credit> mListCredit;
    private LayoutInflater inflater;
    private Context context;

    public CreditAdapter(Context context, ArrayList<Credit> mListCredit) {
        this.inflater = LayoutInflater.from(context);
        this.mListCredit = mListCredit;
        this.context = context;
    }
    @NonNull
    @Override
    public CreditViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.goi_credit_item,parent,false);
        return new CreditViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditViewHolder holder, int position) {
        Credit credit = this.mListCredit.get(position);
        holder.txttengoicredit.setText(credit.getTenGoiCredit());
        holder.txtsotien.setText(credit.getSoTien() + " VND ");
    }

    @Override
    public int getItemCount() {
        return this.mListCredit.size();
    }

    public class CreditViewHolder extends RecyclerView.ViewHolder {
        private TextView txttengoicredit, txtsotien;
        private CreditAdapter adapter;
        public CreditViewHolder(@NonNull View itemView, CreditAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.txttengoicredit = itemView.findViewById(R.id.txtTenGoi);
            this.txtsotien = itemView.findViewById(R.id.txtSoTien);
        }
    }
}
