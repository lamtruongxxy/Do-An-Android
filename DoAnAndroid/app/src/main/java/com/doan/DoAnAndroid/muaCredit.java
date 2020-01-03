package com.doan.DoAnAndroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doan.DoAnAndroid.Adapter.CreditAdapter;
import com.doan.DoAnAndroid.Class.Credit;
import com.doan.DoAnAndroid.Loader.CreditLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class muaCredit extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private RecyclerView rcvGoiCredit;
    private ArrayList<Credit> mLstCredit;
    private CreditAdapter adapter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private String token;

    private final static String FILE_NAME_SHAREREF = "com.doan.DoAnAndroid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muacredit);

        this.mLstCredit = new ArrayList<>();
        this.rcvGoiCredit = this.findViewById(R.id.rcvGoiCredit);
        this.adapter = new CreditAdapter(this, this.mLstCredit);
        this.rcvGoiCredit.setAdapter(this.adapter);
        this.rcvGoiCredit.setLayoutManager(new GridLayoutManager(this, 2)); // phan ra 2 bên
        this.rcvGoiCredit.addItemDecoration(new CreditGD(2, 64, true)); //chia khoang cach

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
    @Override
    public void finish() {
        super.finish();
    }


    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new CreditLoader(this,token);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        Log.d("creditTest", data); //test
        try {
            JSONObject obj = new JSONObject(data);
            JSONArray items = obj.getJSONArray("data");
            for (int i=0; i<items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                int id = item.getInt("id");
                String tenGoiCredit = item.getString("ten_goi");
                int soTien = item.getInt("so_tien");
                int soCredit = item.getInt("credit");

                this.mLstCredit.add(new Credit(id, tenGoiCredit, soTien, soCredit));
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
