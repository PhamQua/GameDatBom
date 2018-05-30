package com.example.sang.vdda;

/**
 * Created by asus on 01/03/2018.
 */

public class Bom {


    public int getDoManh() {
        return doManh;
    }

    public void setDoManh(int doManh) {
        this.doManh = doManh;
    }




    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }




    public int getBienDem() {
        return bienDem;
    }

    public void setBienDem(int bienDem) {
        this.bienDem = bienDem;
    }
    private  int doManh=2;
    private  int thoigian=7;// thoi gian no
    private  int bienDem=0;// dem den thoi gian no
    private  int toadoX=-1;
    private  int toadoY=-1;
    public int getToadoX() {
        return toadoX;
    }

    public void setToadoX(int toadoX) {
        this.toadoX = toadoX;
    }

    public int getToadoY() {
        return toadoY;
    }

    public void setToadoY(int toadoY) {
        this.toadoY = toadoY;
    }



    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private  boolean flag=false;//ranh


}
