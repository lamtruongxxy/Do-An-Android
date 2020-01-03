package com.doan.DoAnAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.doan.DoAnAndroid.Loader.DangKyLoader;

import org.json.JSONException;
import org.json.JSONObject;

public class DangKi extends AppCompatActivity {
    private EditText txtHoTen, txtTenDangNhap, txtEmail, txtMK, txtReMK;
    private ImageView img_avatar;
    private Button btnDangKy;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki);

        txtHoTen=findViewById(R.id.txtHoTen);
        txtTenDangNhap=findViewById(R.id.txtTenDangNhap);
        txtEmail=findViewById(R.id.txtEmail);
        txtMK=findViewById(R.id.txtMatKhau);
        txtReMK=findViewById(R.id.txtNhapLaiMK);
        btnDangKy=findViewById(R.id.btndangky);

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.file_name_shared_preferences), MODE_PRIVATE);
        editor = sharedPreferences.edit();

        txtHoTen.requestFocus();
    }

    public void thongBao()
    {
        taoThongBao("Thông Báo !", "Đăng ký thành công").show();
    }
    public void clickDangKy(View view) {
       // btnDangKy.setEnabled(false);

        String hoTen = txtHoTen.getText().toString();
        String tenDangNhap = txtTenDangNhap.getText().toString();
        String email = txtEmail.getText().toString();
        String matKhau = txtMK.getText().toString();
        String xacNhanMatKhau = txtReMK.getText().toString();

//kiểm tra dữ liệu
        if (!matKhau.equals(xacNhanMatKhau)) {
            taoThongBao("Lỗi", "Mật khẩu xác nhận không trùng khớp").show();
            btnDangKy.setEnabled(true);
            return;
        }
        else if (hoTen.equals("")||tenDangNhap.equals("")||email.equals("")||matKhau.equals("")||matKhau.equals("")||xacNhanMatKhau.equals("")){
            taoThongBao("Lỗi", "Dữ liệu không được bỏ trống").show();
        }


        new DangKyLoader(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //btnDangKy.setEnabled(true);
                try {
                    JSONObject obj = new JSONObject(s);
                    boolean status = obj.getBoolean("status");

                    if (status) {
                        thongBao();
                        String token = "Bearer " + obj.getString("token");
                        editor.putString("TOKEN", token);
                        editor.commit();
                        finish();
                    } else {
                        String msg = obj.getString("message");
                        taoThongBao("Lỗi", msg).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.execute(tenDangNhap, email, matKhau, hoTen);
    }
    public AlertDialog taoThongBao(String tieuDe, String thongBao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(thongBao).setTitle(tieuDe);
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                xoaForm();
            }
        });
        return builder.create();
    }
    public void xoaForm(){
        txtHoTen.setText("");
        txtTenDangNhap.setText("");
        txtEmail.setText("");
        txtMK.setText("");
        txtReMK.setText("");
    }
}
