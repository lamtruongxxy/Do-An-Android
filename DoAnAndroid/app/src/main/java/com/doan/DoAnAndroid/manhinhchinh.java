package com.doan.DoAnAndroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.doan.DoAnAndroid.Loader.ThongTinNguoiChoiLoader;

import org.json.JSONException;
import org.json.JSONObject;

public class manhinhchinh extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private TextView tenTk;
    private TextView soCredit;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private String token;

    private final static String FILE_NAME_SHAREREF = "com.doan.DoAnAndroid";

    public void setIntent (Class lop){
        Intent intent = new Intent(getApplicationContext(),lop);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchinh);

        tenTk=findViewById(R.id.txtTenCuaTk);
        soCredit=findViewById(R.id.txtcredit);

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
    public AlertDialog taoThongBao(String tieuDe, String thongBao) {
        //tạo hộp thoại thông báo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(thongBao).setTitle(tieuDe);
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setIntent(dangnhap.class);
            }
        });
        return builder.create();
    }
    public void btnDangXuat(View view) {
//        Intent intent =new Intent(this,dangnhap.class);
//        startActivity(intent);
        editor.clear();//xoa
        editor.commit();//xac nhan
        taoThongBao("Thông báo","Bạn Có Muốn Thoát").show();
    }

    public void btnQuanLyTaiKhoan(View view) {
        Intent intent =new Intent(this,quanLyTaiKhoan.class);
        startActivity(intent);
    }

    public void startgame(View view) {
        Intent intent =new Intent(this,ChonLinhVuc.class);
        startActivity(intent);
    }

    public void lichSuGame(View view) {
        Intent intent =new Intent(this,lichSuChoi.class);
        startActivity(intent);
    }

    public void bangXepHang1(View view) {
        Intent intent =new Intent(this,bangXepHang.class);
        startActivity(intent);
    }

    public void btnMuaCredit(View view) {
        Intent intent =new Intent(this,muaCredit.class);
        startActivity(intent);
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
            Log.d("ThongTintaikhoan",data);//test xem có lấy dữ lịu đc không
            tenTk.setText(jsonObject.getString("ten_dang_nhap"));
            soCredit.setText(jsonObject.getString("credit"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
