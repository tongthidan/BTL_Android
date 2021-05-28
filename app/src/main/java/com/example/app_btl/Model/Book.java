package com.example.app_btl.Model;

import android.widget.ImageView;

import java.io.Serializable;

public class Book implements Serializable {

    int id;
    int  idanhSach;
    String tenSach;
    String mota;
    String loaiSach;
    double giaSach;

    public Book() {
    }

    public Book(int idanhSach, String tenSach, String mota, String loaiSach, double giaSach) {
        this.idanhSach = idanhSach;
        this.tenSach = tenSach;
        this.mota = mota;
        this.loaiSach = loaiSach;
        this.giaSach = giaSach;
    }

    public Book(int id, int idanhSach, String tenSach, String mota, String loaiSach, double giaSach) {
        this.id = id;
        this.idanhSach = idanhSach;
        this.tenSach = tenSach;
        this.mota = mota;
        this.loaiSach = loaiSach;
        this.giaSach = giaSach;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnhSach() {
        return idanhSach;
    }

    public void setAnhSach(int anhSach) {
        this.idanhSach = idanhSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public double getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(double giaSach) {
        this.giaSach = giaSach;
    }
}
