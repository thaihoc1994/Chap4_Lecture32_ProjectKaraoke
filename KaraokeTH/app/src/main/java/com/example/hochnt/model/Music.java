package com.example.hochnt.model;

import java.io.Serializable;

/**
 * Created by thaihoc on 7/24/2016.
 */
public class Music implements Serializable {
    String ma;
    String ten;
    String caSi;
    Boolean thich;

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public Boolean getThich() {
        return thich;
    }

    public void setThich(Boolean thich) {
        this.thich = thich;
    }

    public Music(String ma, String ten, String caSi, Boolean thich) {
        this.ma = ma;
        this.ten = ten;
        this.caSi = caSi;
        this.thich = thich;
    }

    public Music() {
    }
}
