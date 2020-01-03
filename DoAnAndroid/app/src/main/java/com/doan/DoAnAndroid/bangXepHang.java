package com.doan.DoAnAndroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.doan.DoAnAndroid.Adapter.NguoiChoiAdapter;
import com.doan.DoAnAndroid.Class.clsNguoiChoi;
import com.doan.DoAnAndroid.Loader.NguoiChoiLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class bangXepHang extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private ArrayList<clsNguoiChoi> nguoiChois =new ArrayList<>();
    private RecyclerView mrecyclerView;
    private NguoiChoiAdapter mAdapter;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangxephang);

        mrecyclerView=findViewById(R.id.rcvNguoiChoi);
        mAdapter= new NguoiChoiAdapter(this,this.nguoiChois);
        mrecyclerView.setAdapter(mAdapter);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
        getSupportLoaderManager().restartLoader(0,null,this);
    }


    public void lichSuGame(View view) {
        Intent intent =new Intent(this,lichSuChoi.class);
        startActivity(intent);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new NguoiChoiLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject object=new JSONObject(data);
            JSONArray items=object.getJSONArray("data");
            for (int i=0;i<items.length();i++){
                int id=items.getJSONObject(i).getInt("id");
                String tenNguoiChoi=items.getJSONObject(i).getString("ten_dang_nhap");
                String diemSo=items.getJSONObject(i).getString("diem_cao_nhat");
                this.nguoiChois.add(new clsNguoiChoi(id,tenNguoiChoi,diemSo));
            }
            this.mAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
