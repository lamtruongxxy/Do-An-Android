package com.doan.DoAnAndroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChonLinhVuc extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private ArrayList<clsLinhVuc> mListLinhVuc;
    private LinhVucAdapter adapter;
    private RecyclerView recyclerView;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private String token;

    private final static String FILE_NAME_SHAREREF = "com.doan.DoAnAndroid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chonlinhvuc);

        this.mListLinhVuc = new ArrayList<>();
        this.recyclerView = this.findViewById(R.id.rcvLinhVuc);
        this.adapter = new LinhVucAdapter(this, this.mListLinhVuc);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sharedPreferences = getSharedPreferences(FILE_NAME_SHAREREF, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        token = sharedPreferences.getString("TOKEN", "");

        if (token == "") {
            finish();
        }

        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
        getSupportLoaderManager().restartLoader(0, null, this);
    }


    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) { //tao moi linhvucloader
        return new LinhVucLoader(this, token);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {// nhan chuoi json gan cho cac button
        try {
            JSONObject obj = new JSONObject(data);
            JSONArray items = obj.getJSONArray("data");
            for (int i=0; i<items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                int id = item.getInt("id");
                String tenLinhVuc = item.getString("ten_linh_vuc");
                this.mListLinhVuc.add(new clsLinhVuc(id, tenLinhVuc));
            }
            this.adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
           }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

}

