package com.doan.DoAnAndroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import com.doan.DoAnAndroid.Adapter.LuotChoiAdapter;
import com.doan.DoAnAndroid.Class.LuotChoi;
import com.doan.DoAnAndroid.Loader.LichSuChoiLoader;
import com.doan.DoAnAndroid.Loader.ThongTinNguoiChoiLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class quanLyTaiKhoan extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private TextView txtTenTk;
    private TextView txtEmail;
    private TextView txtDiemCao;
    private TextView txtPass;
    private TextView txtNhappass;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private String token;

    private final static String FILE_NAME_SHAREREF = "com.doan.DoAnAndroid";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlytaikhoan);

        txtTenTk=findViewById(R.id.edittexttentk);
        txtEmail=findViewById(R.id.edittextEmail);
        txtDiemCao=findViewById(R.id.edittextDiemCaoNhat);
        txtPass=findViewById(R.id.edittextDoiMK);
        txtNhappass=findViewById(R.id.edittextNhapLaiMKDoi);

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
        startActivity(new Intent(getApplicationContext(),manhinhchinh.class));
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new ThongTinNguoiChoiLoader(this,token);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            Log.d("ThongTinNguoiChoi",data);//test xem có lấy dữ lịu đc không
            txtTenTk.setText(jsonObject.getString("ten_dang_nhap"));
            txtEmail.setText(jsonObject.getString("email"));
            txtDiemCao.setText(jsonObject.getString("diem_cao_nhat"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    public void btnCapNhatMK(View view) {
        if (txtPass.equals(txtNhappass)==true)
        {
            Toast.makeText(this, "Đổi Mật Khẩu Thành Công", Toast.LENGTH_SHORT).show();
            txtPass.setText("");
            txtNhappass.setText("");
        }
        else
        {
            Toast.makeText(this, "Đổi Mật Khẩu Thất Bại", Toast.LENGTH_SHORT).show();
            txtPass.setText("");
            txtNhappass.setText("");
        }

    }
}
