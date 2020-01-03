package com.doan.DoAnAndroid.Class;

public class LuotChoi {
    private int id;
    private int nguoiChoiId;
    private int soCau;
    private int soDiem;
    private String dateCreate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNguoiChoiId() {
        return nguoiChoiId;
    }

    public void setNguoiChoiId(int nguoiChoiId) {
        this.nguoiChoiId = nguoiChoiId;
    }

    public int getSoCau() {
        return soCau;
    }

    public void setSoCau(int soCau) {
        this.soCau = soCau;
    }

    public int getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(int soDiem) {
        this.soDiem = soDiem;
    }


    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }
    public LuotChoi (int nguoiChoiId,int soCau,int soDiem)
    {
        this.id = 0;
        this.nguoiChoiId = nguoiChoiId;
        this.soCau = soCau;
        this.soDiem = soDiem;
    }
    public LuotChoi(int soCau,int soDiem, String dateCreate)
    {
        this.id = 0;
        this.nguoiChoiId = 0;
        this.soCau = soCau;
        this.soDiem = soDiem;
        this.dateCreate = dateCreate;
    }
}
