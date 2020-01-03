package com.doan.DoAnAndroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.doan.DoAnAndroid.Adapter.LuotChoiAdapter;
import com.doan.DoAnAndroid.Class.LuotChoi;
import com.doan.DoAnAndroid.Loader.LichSuChoiLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class lichSuChoi extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{
    private ArrayList<LuotChoi> mlstLuotChoi;
    private LuotChoiAdapter luotChoiAdapter;
    private RecyclerView recyclerView;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private String token;
    private String user_id;

    private final static String FILE_NAME_SHAREREF = "com.doan.DoAnAndroid";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichsuchoi);

        this.mlstLuotChoi = new ArrayList<>();
        this.recyclerView = this.findViewById(R.id.rcvLichSuChoi);
        this.luotChoiAdapter = new LuotChoiAdapter(this,this.mlstLuotChoi);
        this.recyclerView.setAdapter(this.luotChoiAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sharedPreferences = getSharedPreferences(FILE_NAME_SHAREREF, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        token = sharedPreferences.getString("TOKEN", "");
        user_id = sharedPreferences.getString("ID_USER","");

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
        startActivity(new Intent(getApplicationContext(),manhinhchinh.class));
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new LichSuChoiLoader(this,token,user_id);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            if(data == null)
            {
                taoThongBao("Không thể kết nối server").show();
                return;
            }
            JSONObject jsonObject = new JSONObject(data);
            Log.d("LichSuChoia",data);//test xem có lấy dữ lịu đc không
            JSONArray itemArray = jsonObject.getJSONArray("data");

            for(int i = 0;i<itemArray.length();i++)
            {
                int so_cau = itemArray.getJSONObject(i).getInt("so_cau");
                int diem = itemArray.getJSONObject(i).getInt("diem");
                String dateCreate = itemArray.getJSONObject(i).getString("created_at");

                this.mlstLuotChoi.add(new LuotChoi(so_cau,diem,dateCreate));
            }
            this.luotChoiAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
    private AlertDialog taoThongBao(String msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg).setTitle("Lỗi");
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        return  builder.create();
    }
    public void rank(View view) {
        Intent intent =new Intent(this,bangXepHang.class);
        startActivity(intent);
    }
}
