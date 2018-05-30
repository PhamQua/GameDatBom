package com.example.sang.vdda;

/**
 * Created by asus on 28/02/2018.
 */

public class HangSo {
    public static int getChieudaio() {
        return Chieudaio;
    }
    public static int buocDiChuyenQuai=1;
    private int thoiGianVan=60;
    public int getThoiGianVan() {
        return thoiGianVan;
    }

    public void setThoiGianVan(int thoiGianVan) {
        this.thoiGianVan = thoiGianVan;
    }


    public static void setChieudaio(int chieudaio) {
        Chieudaio = chieudaio;
    }

    public int getChieuDaiBan() {
        return chieuDaiBan;
    }

    public void setChieuDaiBan(int chieuDaiBan) {
        this.chieuDaiBan = chieuDaiBan;
    }

    public int getChieuRongBan() {
        return chieuRongBan;
    }

    public void setChieuRongBan(int chieuRongBan) {
        this.chieuRongBan = chieuRongBan;
    }



    public float getBuocDichuyen() {
        return buocDichuyen;
    }

    public void setBuocDichuyen(float buocDichuyen) {
        this.buocDichuyen = buocDichuyen;
    }


    public float getTiSopxdp() {
        return tiSopxdp;
    }

    public void setTiSopxdp(float tiSopxdp) {
        this.tiSopxdp = tiSopxdp;
    }
    private int chieuDaiBan=15;
    private int chieuRongBan=9;
    public static int Chieudaio=30;
    private float buocDichuyen=1;
    private float tiSopxdp;
    private int soGach=30;

    public int getMangNV() {
        return mangNV;
    }

    public void setMangNV(int mangNV) {
        this.mangNV = mangNV;
    }

    public int getSobomNV() {
        return sobomNV;
    }

    public void setSobomNV(int sobomNV) {
        this.sobomNV = sobomNV;
    }

    private int mangNV=2;
    private int sobomNV=3;

    public int getSotangdomanh() {
        return sotangdomanh;
    }

    public void setSotangdomanh(int sotangdomanh) {
        this.sotangdomanh = sotangdomanh;
    }

    private int sotangdomanh=5;
    private int soTangTocDo=4;
    private int soTangSLBom=5;
    private int soTangMang=4;

    public int getSoLuongQuai() {
        return soLuongQuai;
    }

    public void setSoLuongQuai(int soLuongQuai) {
        this.soLuongQuai = soLuongQuai;
    }

    private int soLuongQuai=1;

    public int getSoTangTocDo() {
        return soTangTocDo;
    }

    public void setSoTangTocDo(int soTangTocDo) {
        this.soTangTocDo = soTangTocDo;
    }

    public int getSoTangSLBom() {
        return soTangSLBom;
    }

    public void setSoTangSLBom(int soTangSLBom) {
        this.soTangSLBom = soTangSLBom;
    }

    public int getSoTangMang() {
        return soTangMang;
    }

    public void setSoTangMang(int soTangMang) {
        this.soTangMang = soTangMang;
    }




    public int getSoGach() {
        return soGach;
    }

    public void setSoGach(int soGach) {
        this.soGach = soGach;
    }




}
