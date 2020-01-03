package com.doan.DoAnAndroid.Class;

import android.os.Parcel;
import android.os.Parcelable;

public class CauHoi implements Parcelable {
    private int id;
    private String noiDungCauHoi;
    private String dap_an_a;
    private String dap_an_b;
    private String dap_an_c;
    private String dap_an_d;
    private String dap_an;

    protected CauHoi(Parcel in) {
        id = in.readInt();
        noiDungCauHoi = in.readString();
        dap_an_a = in.readString();
        dap_an_b = in.readString();
        dap_an_c = in.readString();
        dap_an_d = in.readString();
        dap_an = in.readString();
    }

    public static final Creator<CauHoi> CREATOR = new Creator<CauHoi>() {
        @Override
        public CauHoi createFromParcel(Parcel in) {
            return new CauHoi(in);
        }

        @Override
        public CauHoi[] newArray(int size) {
            return new CauHoi[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDungCauHoi() {
        return noiDungCauHoi;
    }

    public void setNoiDungCauHoi(String noiDungCauHoi) {
        this.noiDungCauHoi = noiDungCauHoi;
    }

    public String getDap_an_a() {
        return dap_an_a;
    }

    public void setDap_an_a(String dap_an_a) {
        this.dap_an_a = dap_an_a;
    }

    public String getDap_an_b() {
        return dap_an_b;
    }

    public void setDap_an_b(String dap_an_b) {
        this.dap_an_b = dap_an_b;
    }

    public String getDap_an_c() {
        return dap_an_c;
    }

    public void setDap_an_c(String dap_an_c) {
        this.dap_an_c = dap_an_c;
    }

    public String getDap_an_d() {
        return dap_an_d;
    }

    public void setDap_an_d(String dap_an_d) {
        this.dap_an_d = dap_an_d;
    }

    public String getDap_an() {
        return dap_an;
    }

    public void setDap_an(String dap_an) {
        this.dap_an = dap_an;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(noiDungCauHoi);
        dest.writeString(dap_an_a);
        dest.writeString(dap_an_b);
        dest.writeString(dap_an_c);
        dest.writeString(dap_an_d);
        dest.writeString(dap_an);
    }
}
