package com.doan.DoAnAndroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChonLinhVuc extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private Button btnLinhVuc1;
    private Button btnLinhVuc2;
    private Button btnLinhVuc3;
    private Button btnLinhVuc4;
    private Button btnLinhVuc5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chonlinhvuc);
        btnLinhVuc1 = findViewById(R.id.btnLinhVuc1);
        btnLinhVuc2 = findViewById(R.id.btnLinhVuc2);
        btnLinhVuc3 = findViewById(R.id.btnLinhVuc3);
        btnLinhVuc4 = findViewById(R.id.btnLinhVuc4);
        btnLinhVuc5 = findViewById(R.id.btnLinhVuc5);
        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
        getSupportLoaderManager().restartLoader(0, null, this);

    }


    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) { //tao moi linhvucloader
        return new LinhVucLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {// nhan chuoi json gan cho cac button

        try {
            JSONObject jsonObject = new JSONObject(data); // nhan chuoi json o localhost
            JSONArray jsonArray = jsonObject.getJSONArray("data"); //lay danh sach
            btnLinhVuc1.setText(jsonArray.getJSONObject(0).getString("ten_linh_vuc"));
            btnLinhVuc2.setText(jsonArray.getJSONObject(1).getString("ten_linh_vuc"));
            btnLinhVuc3.setText(jsonArray.getJSONObject(2).getString("ten_linh_vuc"));
            btnLinhVuc4.setText(jsonArray.getJSONObject(3).getString("ten_linh_vuc"));
            btnLinhVuc5.setText(jsonArray.getJSONObject(4).getString("ten_linh_vuc"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    public void btnmanhinhtrochoi(View view) {
        Intent intent = new Intent(this, ManHinhTroChoi.class);
        startActivity(intent);
    }
}

