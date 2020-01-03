package com.doan.DoAnAndroid.Class;

import android.os.Parcel;
import android.os.Parcelable;

public class clsNguoiChoi implements Parcelable {
    private int  id;
    private String tenNguoiChoi;
    private String diemSo;

    public clsNguoiChoi(int id,String tenNguoiChoi,String diemSo){
        this.id=id;
        this.tenNguoiChoi=tenNguoiChoi;
        this.diemSo=diemSo;
    }

    protected clsNguoiChoi(Parcel in) {
        id = in.readInt();
        tenNguoiChoi = in.readString();
        diemSo = in.readString();
    }

    public static final Creator<clsNguoiChoi> CREATOR = new Creator<clsNguoiChoi>() {
        @Override
        public clsNguoiChoi createFromParcel(Parcel in) {
            return new clsNguoiChoi(in);
        }

        @Override
        public clsNguoiChoi[] newArray(int size) {
            return new clsNguoiChoi[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNguoiChoi() {
        return tenNguoiChoi;
    }

    public void setTenNguoiChoi(String tenNguoiChoi) {
        this.tenNguoiChoi = tenNguoiChoi;
    }

    public String getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(String diemSo) {
        this.diemSo = diemSo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(tenNguoiChoi);
        dest.writeString(diemSo);
    }
}
