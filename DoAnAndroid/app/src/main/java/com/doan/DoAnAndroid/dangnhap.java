package com.doan.DoAnAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class dangnhap extends AppCompatActivity {
    Button btnDangNhap, btnDangKi,btnQuenMatKhau;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static  final String FILE_NAME_SHAREREF="com.doan.DoAnAndroid";

    public void  AnhXa(){
        btnDangNhap=findViewById(R.id.btnDangNhap);
        btnDangKi=findViewById(R.id.btnDangKy);
        btnQuenMatKhau=findViewById(R.id.btnQuenMatKhau);

        sharedPreferences = getSharedPreferences(FILE_NAME_SHAREREF, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setIntent (Class lop){
        Intent intent = new Intent(getApplicationContext(),lop);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String token = sharedPreferences.getString("TOKEN", ""); // luu tokeen
        Log.d("TOKEN", token);
        if (token != "") {
            Intent intent = new Intent(this, manhinhchinh.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        AnhXa();

        String token = sharedPreferences.getString("TOKEN", "");
        Log.d("tokenabc", token); // tesst
        if (token != "") {
            Intent intent = new Intent(this, manhinhchinh.class);
            startActivity(intent);
        }
//
        btnQuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setIntent(quenMatKhau.class);
            }
        });

    }

    public void launchActivityMenu() {
        setIntent(manhinhchinh.class);
    }

    public void dangKy(View view) {
       Intent intent =new Intent(this,DangKi.class);
        startActivity(intent);
    }

    public void btnLayMatKhau(View view) {
       // Intent intent =new Intent(this,quenMatKhau.class);
       // startActivity(intent);
    }
    public void btnDangNhap(View view) {
       // Intent intent =new Intent(this,manhinhchinh.class);
       // startActivity(intent);
        EditText txtTenDangNhap = findViewById(R.id.tendangnhap_dangnhap_edittext);
        EditText txtMatKhau = findViewById(R.id.matkhau_dangnhap_edittext);

        String tenDangNhap = txtTenDangNhap.getText().toString();
        String matKhau = txtMatKhau.getText().toString();

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Đang đăng nhập");
        dialog.setMessage("Đang xử lý...");
        dialog.show();
        new DangNhapLoader(){
            @Override
            protected void onPostExecute(String s) {
                dialog.cancel();
                try {
                    JSONObject json = new JSONObject(s);
                    boolean success = json.getBoolean("status");
                    if (success==false) {
                        String msg = json.getString("message");
                        Log.d("ThongBaoMSG1",msg);
                        taoThongBao("Thông báo", msg).show();
                    }
                    else {
                        String token = "Bearer " + json.getString("token");
                        String id = json.getJSONObject("user").getString("id");
                        String ten_dang_nhap = json.getJSONObject("user").getString("ten_dang_nhap");
                        Log.d("USER_ID",id+"");
                        editor.putString("HOTEN",ten_dang_nhap);
                        editor.commit();
                        editor.putString("ID_USER",id);
                        editor.commit();
                        editor.putString("TOKEN", token);
                        editor.commit();
                        launchActivityMenu();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.execute(tenDangNhap, matKhau);
    }
    public AlertDialog taoThongBao(String tieuDe, String thongBao) {
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

}
