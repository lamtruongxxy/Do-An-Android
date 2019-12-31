package com.doan.DoAnAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class manhinhchinh extends AppCompatActivity {
    MediaPlayer mediaPlayer; // khai bao nhac

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static  final String FILE_NAME_SHAREREF="com.doan.DoAnAndroid";

    public void setIntent (Class lop){
        Intent intent = new Intent(getApplicationContext(),lop);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchinh);

        sharedPreferences = getSharedPreferences(FILE_NAME_SHAREREF, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String token = sharedPreferences.getString("TOKEN", "");
        if (token == "") {
            finish();
        }

        mediaPlayer = MediaPlayer.create(manhinhchinh.this,R.raw.musicbackground2);
        mediaPlayer.start();
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
        mediaPlayer.stop();// tat nhac
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
}
