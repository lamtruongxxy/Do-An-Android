package com.doan.DoAnAndroid;

public class clsLinhVuc {
    private int id;
    private String tenLinhVuc;

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTenLinhVuc() {

        return tenLinhVuc;
    }

    public void setTenLinhVuc(String tenLinhVuc) {

        this.tenLinhVuc = tenLinhVuc;
    }

    public clsLinhVuc(int id, String tenLinhVuc) {
        this.id = id;
        this.tenLinhVuc = tenLinhVuc;
    }
}
