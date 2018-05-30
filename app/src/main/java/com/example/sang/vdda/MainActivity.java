package com.example.sang.vdda;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtthoiGian;
    TextView txtdoManh;
    TextView txtmang;
    TextView txttocDo;
    TextView txtbom;
    TextView txtgameover;

    Bom bom1 = new Bom();
    Bom bom2 = new Bom();
    Bom bom3 = new Bom();
    Bom bom4 = new Bom();
    Bom bom5 = new Bom();
    // List<Bom> bombs=new ArrayList<Bom>();
    CountDownTimer bomno;
    CountDownTimer bomno2;
    CountDownTimer bomno3;
    CountDownTimer bomno4;
    CountDownTimer bomno5;
    CountDownTimer quaiDiChuyen;
    CountDownTimer CDthoiGian;
    GridView grvBan;
    ImageView imageNv;
    ImageView imageQuai;
    ImageView imageQuai2;
    ImageView imgoVuong;
    ImageButton btnBom;
    ImageButton btnTren;
    ImageButton btnDuoi;
    ImageButton btnTrai;
    ImageButton btnPhai;
    int duongQuaiChay = 0;
    int Quaiflag=5;
    ArrayList<HinhAnh> listHinhAnh;
    //int mangChiSo[][]= new int[30][30];
    int mangKT[][] = new int[30][30];
    List<Point> dsGach = new ArrayList<Point>();
    HinhanhAdapter adapter;
    HangSo hangso = new HangSo();
    CungCap tangdomanh = new CungCap(R.drawable.tangdomanh);
    CungCap tangmang = new CungCap(R.drawable.themmang);
    CungCap tangbom = new CungCap(R.drawable.tangbom);
    CungCap tangtocdo = new CungCap(R.drawable.tangtocdo);
    Random rd=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hangso.setTiSopxdp(convertPixelsToDp(this));



        AnhXa();
        VeManHinh();



        btnTren.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (DkNutTren()) {

                    imageNv.setY(imageNv.getY() - hangso.getBuocDichuyen());
                } else if (DkNutTrai()) {
                    imageNv.setX(imageNv.getX() - hangso.getBuocDichuyen());
                }
                return false;
            }
        });

        btnDuoi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (DkNutDuoi()) {
                    imageNv.setY(imageNv.getY() + hangso.getBuocDichuyen());
                } else if (DkNutTrai()) {
                    imageNv.setX(imageNv.getX() - hangso.getBuocDichuyen());
                }

                return false;
            }
        });
        btnTrai.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (DkNutTrai()) {
                    imageNv.setX(imageNv.getX() - hangso.getBuocDichuyen());
                } else if (DkNutDuoi()) {
                    imageNv.setY(imageNv.getY() + hangso.getBuocDichuyen());
                }
                return false;
            }
        });
        btnPhai.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (DkNutPhai()) {
                    imageNv.setX(imageNv.getX() + hangso.getBuocDichuyen());
                } else {

//                    if ( (imageNv.getY() * hangso.getTiSopxdp() + hangso.Chieudaio / 2) % hangso.Chieudaio <= hangso.Chieudaio / 2) {
//
//                        imageNv.setY(imageNv.getY() - hangso.getBuocDichuyen());
//
//                    } else
//                    {

                    if (DkNutDuoi()) {
                        imageNv.setY(imageNv.getY() + hangso.getBuocDichuyen());
                    }
                    //  }
                }

                return false;
            }
        });

        bomno = new CountDownTimer(500*(bom1.getThoigian()+2), 500) {
            @Override
            public void onTick(long millisUntilFinished) {

                XuLiBomNo(bom1, this);

            }

            @Override
            public void onFinish() {
            }
        };
        bomno2 = new CountDownTimer(500*(bom1.getThoigian()+2), 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                XuLiBomNo(bom2, this);
            }

            @Override
            public void onFinish() {
            }
        };
        bomno3 = new CountDownTimer(90000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

                XuLiBomNo(bom3, this);
            }

            @Override
            public void onFinish() {
            }
        };
        bomno4 = new CountDownTimer(500*(bom1.getThoigian()+2), 500) {
            @Override
            public void onTick(long millisUntilFinished) {

                XuLiBomNo(bom4, this);
            }

            @Override
            public void onFinish() {
            }
        };
        bomno5 = new CountDownTimer(500*(bom1.getThoigian()+2), 500) {
            @Override
            public void onTick(long millisUntilFinished) {

                XuLiBomNo(bom5, this);
            }

            @Override
            public void onFinish() {
            }
        };
        quaiDiChuyen = new CountDownTimer(900000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                //QuaiDiChuyen();

            }

            @Override
            public void onFinish() {
            }

        };
        CDthoiGian= new CountDownTimer(900000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(hangso.getThoiGianVan()>0){
                    hangso.setThoiGianVan(hangso.getThoiGianVan()-1);
                    txtthoiGian.setText(String.valueOf(hangso.getThoiGianVan()));
                }
                else
                {
                    //KetThucGame();
                }


            }

            @Override
            public void onFinish() {
            }};

        btnBom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x, y;
                int sobom=hangso.getSobomNV();
                y = (int) ((imageNv.getY() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getY() * hangso.getTiSopxdp()) / hangso.Chieudaio);
                x = (int) ((imageNv.getX() * hangso.getTiSopxdp() + hangso.Chieudaio / 2 - grvBan.getX() * hangso.getTiSopxdp()) / hangso.Chieudaio);

                if (bom1.isFlag() == false) {

                    ChonBom(x, y, bom1, bomno);
                    return;
                }
                if (bom2.isFlag() == false&&sobom>1) {
                    ChonBom(x, y, bom2, bomno2);
                    return;
                }
                if (bom3.isFlag() == false&&sobom>2) {
                    ChonBom(x, y, bom3, bomno3);
                    return;
                }
                if (bom4.isFlag() == false&&sobom>3) {
                    ChonBom(x, y, bom4, bomno4);
                    return;
                }
                if (bom5.isFlag() == false&&sobom>4) {
                    ChonBom(x, y, bom5, bomno5);
                    return;
                }

            }
        });
        quaiDiChuyen.start();
        CDthoiGian.start();
    }

    void NextBoom(int vx, int vy){

        if(bom1.getToadoX()==vx&& bom1.getToadoY()==vy){
            bom1.setBienDem(bom1.getThoigian()-1);
        }
        if(bom2.getToadoX()==vx&& bom2.getToadoY()==vy){
            bom2.setBienDem(bom2.getThoigian()-1);
        }
        if(bom3.getToadoX()==vx&& bom3.getToadoY()==vy){
            bom3.setBienDem(bom3.getThoigian()-1);
        }
        if(bom4.getToadoX()==vx&& bom4.getToadoY()==vy){
            bom4.setBienDem(bom4.getThoigian()-1);
        }
        if(bom5.getToadoX()==vx&& bom5.getToadoY()==vy){
            bom5.setBienDem(bom5.getThoigian()-1);
        }


    }
    void XuLiBomNo(Bom vbom, CountDownTimer timer) {
        int tren = 0, duoi = 0, trai = 0, phai = 0;
        int t = (vbom.getToadoY() * hangso.getChieuDaiBan()) + vbom.getToadoX();
        if (vbom.getBienDem() == vbom.getThoigian() - 1) {
            listHinhAnh.set(t, new HinhAnh(R.drawable.lua));
            for (int i = 1; i < vbom.getDoManh(); i++)

            {

                if (phai == 0 && (t + i) % hangso.getChieuDaiBan() != 0 && mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 + i] != 2)//nut phai
                {
                    listHinhAnh.set(t + i, new HinhAnh(R.drawable.lua));
                    if (mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 + i] == 1) {
                        phai = 1;
                    }
                    if(i!=1)
                    NextBoom(vbom.getToadoX() + 1 + i,vbom.getToadoY() + 1 );

                    // mangKT[vbom.getToadoY()+1][vbom.getToadoX()+1+i]=0;
                } else {
                    phai = 1;
                }
                if (trai == 0 && (t - i + 1) % hangso.getChieuDaiBan() != 0 && mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 - i] != 2)//nut trai
                {
                    listHinhAnh.set(t - i, new HinhAnh(R.drawable.lua));
                    if (mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 - i] == 1) {
                        trai = 1;
                    } if(i!=1)
                    NextBoom(vbom.getToadoX() + 1 - i,vbom.getToadoY() + 1 );
                    /*mangKT[vbom.getToadoY()+1][vbom.getToadoX()+1-i]=0;*/
                } else {
                    trai = 1;
                }

                if (duoi == 0 && t + (i - 1) * (hangso.getChieuDaiBan()) < hangso.getChieuDaiBan() * (hangso.getChieuRongBan() - 1) && mangKT[vbom.getToadoY() + i + 1][vbom.getToadoX() + 1] != 2)// nut duoi
                {
                    listHinhAnh.set(t + (i) * hangso.getChieuDaiBan(), new HinhAnh(R.drawable.lua));
                    if (mangKT[vbom.getToadoY() + i + 1][vbom.getToadoX() + 1] == 1) {
                        duoi = 1;
                    } if(i!=1)
                    NextBoom(vbom.getToadoX() + 1,vbom.getToadoY()+i + 1 );
                    /*mangKT[vbom.getToadoY()+i+1][vbom.getToadoX()+1]=0;*/
                } else {
                    duoi = 1;
                }
                if (tren == 0 && t - (i - 1) * (hangso.getChieuDaiBan()) > hangso.getChieuDaiBan() + 1 && mangKT[vbom.getToadoY() - i + 1][vbom.getToadoX() + 1] != 2)// nut tren
                {
                    listHinhAnh.set(t - (i) * hangso.getChieuDaiBan(), new HinhAnh(R.drawable.lua));
                    if (mangKT[vbom.getToadoY() - i + 1][vbom.getToadoX() + 1] == 1) {
                        tren = 1;
                    } if(i!=1)
                    NextBoom(vbom.getToadoX() + 1,vbom.getToadoY()-i + 1 );
                   /* mangKT[vbom.getToadoY()-i+1][vbom.getToadoX()+1]=0;*/
                } else {
                    tren = 1;
                }
            }
            adapter.notifyDataSetChanged();

        }




        if (vbom.getBienDem() == vbom.getThoigian()) {
            vbom.setFlag(false);

            tren = 0;
            duoi = 0;
            trai = 0;
            phai = 0;

            listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));

            for (int i = 1; i < vbom.getDoManh(); i++)

            {

                if (phai == 0 && (t + i) % hangso.getChieuDaiBan() != 0 && mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 + i] != 2)//nut phai
                {

                    if (mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 + i] == 1) {
                        phai = 1;
                    }


                   // listHinhAnh.set(t + i, new HinhAnh(R.drawable.ovuong));
                    XLSauKhiNo(vbom.getToadoY() + 1, vbom.getToadoX() + 1 + i, t + i);
                } else {
                    phai = 1;
                }
                if (trai == 0 && (t - i + 1) % hangso.getChieuDaiBan() != 0 && mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 - i] != 2)//nut trai
                {

                    if (mangKT[vbom.getToadoY() + 1][vbom.getToadoX() + 1 - i] == 1) {
                        trai = 1;
                    }

                    //listHinhAnh.set(t - i, new HinhAnh(R.drawable.ovuong));
                    XLSauKhiNo(vbom.getToadoY() + 1, vbom.getToadoX() + 1 - i , t - i);
                } else {
                    trai = 1;
                }

                if (duoi == 0 && t + (i - 1) * (hangso.getChieuDaiBan()) < hangso.getChieuDaiBan() * (hangso.getChieuRongBan() - 1) && mangKT[vbom.getToadoY() + i + 1][vbom.getToadoX() + 1] != 2)// nut duoi
                {

                    if (mangKT[vbom.getToadoY() + i + 1][vbom.getToadoX() + 1] == 1) {
                        duoi = 1;
                    }

                    //listHinhAnh.set(t + (i) * hangso.getChieuDaiBan(), new HinhAnh(R.drawable.ovuong));
                   XLSauKhiNo(vbom.getToadoY() + i + 1, vbom.getToadoX() + 1, t + (i) * hangso.getChieuDaiBan() );
                } else {
                    duoi = 1;
                }
                if (tren == 0 && t - (i - 1) * (hangso.getChieuDaiBan()) > hangso.getChieuDaiBan() + 1 && mangKT[vbom.getToadoY() - i + 1][vbom.getToadoX() + 1] != 2)// nut tren
                {
                   // listHinhAnh.set(t - (i) * hangso.getChieuDaiBan(), new HinhAnh(R.drawable.ovuong));

                    if (mangKT[vbom.getToadoY() - i + 1][vbom.getToadoX() + 1] == 1) {
                        tren = 1;
                    }

                    XLSauKhiNo(vbom.getToadoY() - i + 1,vbom.getToadoX() + 1, t - (i) * hangso.getChieuDaiBan());


                } else {
                    tren = 1;
                }
            }


            adapter.notifyDataSetChanged();
            vbom.setBienDem(0);
            ///////
            timer.cancel();

        } else
            vbom.setBienDem(vbom.getBienDem() + 1);


    }

    void XLSauKhiNo(int y, int x, int t)
    {
        listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));
        switch (mangKT[y][x]) {
            case 1:
                mangKT[y][x] = 0;
                break;

            //domanh
            case 3:
                listHinhAnh.set(t, new HinhAnh(tangdomanh.getHinhNV()));
                mangKT[y][x] = 4;
                break;
            case 4:
                mangKT[y][x] = 0;
                listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));

                break;

            //slbom
            case 5:
                listHinhAnh.set(t, new HinhAnh(tangbom.getHinhNV()));
                mangKT[y][x] = 6;
                break;
            case 6:
                mangKT[y][x] = 0;
                listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));

                break;
            //mang
            case 7:
                listHinhAnh.set(t, new HinhAnh(tangmang.getHinhNV()));
                mangKT[y][x] = 8;
                break;
            case 8:
                mangKT[y][x] = 0;
                listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));

                break;
            //tocdo
            case 9:
                listHinhAnh.set(t, new HinhAnh(tangtocdo.getHinhNV()));
                mangKT[y][x] = 10;
                break;
            case 10:
                mangKT[y][x] = 0;
                listHinhAnh.set(t, new HinhAnh(R.drawable.ovuong));

                break;
            default:

                break;


        }
    }
    void ChonBom(int vx, int vy, Bom vbom, CountDownTimer timer){

        vbom.setToadoX(vx);
        vbom.setToadoY(vy);
        vbom.setBienDem(0);

        listHinhAnh.set((vy*hangso.getChieuDaiBan())+vx, new HinhAnh(R.drawable.bomnho));
        adapter.notifyDataSetChanged();

        timer.start();
        vbom.setFlag(true);
    }

    boolean DkNutTren()
    {
        try {
        int x, y;
        y=(int)((imageNv.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
        x=(int)((imageNv.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);

        /*y--;
            x--;*/



            if(DKfalse(x, y)){
                return false;
            }

            int i=(int)((imageNv.getX()*hangso.getTiSopxdp()-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);
                if(imageNv.getX()*hangso.getTiSopxdp()>=grvBan.getX()*hangso.getTiSopxdp()+hangso.Chieudaio*i&&
                        imageNv.getX()*hangso.getTiSopxdp()<=grvBan.getX()*hangso.getTiSopxdp()+hangso.Chieudaio*i)
                {


                        DKnut(x, y);


                    return true;
                }
        }
        catch (ArithmeticException e)

        {
            return false;
        }


        return false;

    }
    boolean DkNutDuoi()
    {
        try {
        int x, y;
            y=(int)((imageNv.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            x=(int)((imageNv.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);

        y++;
            /*y++;
            x++;*/
          /*  if (mangKT[y+1][x+1] ==4) {
               *//* bom1.setDoManh(bom1.getDoManh()+1);
                bom2.setDoManh(bom1.getDoManh());

                mangKT[y+1][x+1] =0;
                listHinhAnh.set(hangso.getChieuDaiBan()*(y-1)+x-1, new HinhAnh(R.drawable.ovuong));
                grvBan.setAdapter(adapter);*//*
                DKnut(x, y);
                return true;
            }*/

            if(DKfalse(x, y)){
            return false;
        }
            //for(int i=0; i<hangso.getChieuDaiBan(); i++)
            int i=(int)((imageNv.getX()*hangso.getTiSopxdp()-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);
                if(imageNv.getX()*hangso.getTiSopxdp()>=grvBan.getX()*hangso.getTiSopxdp()+hangso.Chieudaio*i&&
                        imageNv.getX()*hangso.getTiSopxdp()<=grvBan.getX()*hangso.getTiSopxdp()+hangso.Chieudaio*i)
                {

                        DKnut(x, y);


                    return true;
                }
        }
        catch (ArithmeticException e)

        {
            return false;
        }


        return false;

    }

    boolean DkNutPhai()
    {
        try {
        int x, y;
            y=(int)((imageNv.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            x=(int)((imageNv.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);

        x++;
        /*x++;
            y++;*/
            if(DKfalse(x, y)){
            return false;
        }
            int  i=(int)((imageNv.getY()*hangso.getTiSopxdp()-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            if(imageNv.getY()*hangso.getTiSopxdp()>=grvBan.getY()*hangso.getTiSopxdp()+hangso.Chieudaio*i&&
                    imageNv.getY()*hangso.getTiSopxdp()<=grvBan.getY()*hangso.getTiSopxdp()+hangso.Chieudaio*i)// cho vndi vao chinh giua hang
            {

                    DKnut(x, y);


                return true;
            }
    }
        catch (ArithmeticException e)

    {
        return false;
    }


        return false;

    }

    boolean DkNutTrai()
    {
        try {
            int x, y;
            y=(int)((imageNv.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            x=(int)((imageNv.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);

       /* x--;
            y--;*/

            if(DKfalse(x, y)){
                return false;
            }
            int  i=(int)((imageNv.getY()*hangso.getTiSopxdp()-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            if(imageNv.getY()*hangso.getTiSopxdp()>=grvBan.getY()*hangso.getTiSopxdp()+hangso.Chieudaio*i&&
                    imageNv.getY()*hangso.getTiSopxdp()<=grvBan.getY()*hangso.getTiSopxdp()+hangso.Chieudaio*i)// cho vndi vao chinh giua hang
            {

                DKnut(x, y);


                return true;
            }
        }
        catch (ArithmeticException e)

        {
            return false;
        }


        return false;

    }
    boolean DKfalse(int x, int y){
        if(mangKT[y][x]!=0&&mangKT[y][x]!=4&&mangKT[y][x]!=6&&mangKT[y][x]!=8&&mangKT[y][x]!=10){
            return true;//tra ve la dung de ham tren tr ve sai
        }
        return false;
    }
    void DKnut(int x , int y){
        if (mangKT[y][x] ==4) {
            bom1.setDoManh(bom1.getDoManh()+1);
            bom2.setDoManh(bom2.getDoManh()+1);
            bom3.setDoManh(bom3.getDoManh()+1);
            bom4.setDoManh(bom4.getDoManh()+1);
            bom5.setDoManh(bom5.getDoManh()+1);
            txtdoManh.setText(String.valueOf(bom1.getDoManh()));

            mangKT[y][x] =0;
            listHinhAnh.set(hangso.getChieuDaiBan()*(y-1)+x-1, new HinhAnh(R.drawable.ovuong));
            grvBan.setAdapter(adapter);
            return;
        }
        if (mangKT[y][x] ==6) {//soluongbom

            hangso.setSobomNV(hangso.getSobomNV()+1);

            txtbom.setText(String.valueOf(hangso.getSobomNV()));
            mangKT[y][x] =0;
            listHinhAnh.set(hangso.getChieuDaiBan()*(y-1)+x-1, new HinhAnh(R.drawable.ovuong));
            grvBan.setAdapter(adapter);
            return;
        }
        if (mangKT[y][x] ==8) {//tangmang
            hangso.setMangNV(hangso.getMangNV()+1);

            txtmang.setText(String.valueOf(hangso.getMangNV()));
            mangKT[y][x] =0;
            listHinhAnh.set(hangso.getChieuDaiBan()*(y-1)+x-1, new HinhAnh(R.drawable.ovuong));
            grvBan.setAdapter(adapter);
            return;
        }
        if (mangKT[y][x] ==10) {//tangtocdo
            hangso.setBuocDichuyen(hangso.getBuocDichuyen()+1/3);
            txttocDo.setText(String.valueOf(hangso.getBuocDichuyen()));
            mangKT[y][x] =0;
            listHinhAnh.set(hangso.getChieuDaiBan()*(y-1)+x-1, new HinhAnh(R.drawable.ovuong));
            grvBan.setAdapter(adapter);
            return;
        }



    }


    void AnhXa()
    {
        listHinhAnh =new ArrayList<>();

        imageQuai=(ImageView) findViewById(R.id.quai);
        grvBan=(GridView) findViewById(R.id.banco);
        imgoVuong=(ImageView) findViewById(R.id.ovuong);
        imageNv=(ImageView) findViewById(R.id.nhanvat);
        btnTren=(ImageButton) findViewById(R.id.nuttren);
        btnDuoi=(ImageButton) findViewById(R.id.nutduoi);
        btnTrai=(ImageButton) findViewById(R.id.nuttrai);
        btnPhai=(ImageButton) findViewById(R.id.nutphai);

        txtgameover=(TextView)findViewById(R.id.gameover) ;
        txtthoiGian=(TextView)findViewById(R.id.thoigian) ;
        txtdoManh=(TextView)findViewById(R.id.domanh) ;
        txtmang=(TextView)findViewById(R.id.mang) ;
        txttocDo=(TextView)findViewById(R.id.tocdo) ;
        txtbom=(TextView)findViewById(R.id.bom) ;

        btnBom=(ImageButton) findViewById(R.id.nutbom);
    }

    public void VeManHinh()
    {

        btnTren.setBackgroundColor(Color.TRANSPARENT);
        btnDuoi.setBackgroundColor(Color.TRANSPARENT);
        btnTrai.setBackgroundColor(Color.TRANSPARENT);
        btnPhai.setBackgroundColor(Color.TRANSPARENT);
        btnBom.setBackgroundColor(Color.TRANSPARENT);
        //imgoVuong.set
        grvBan.setNumColumns(hangso.getChieuDaiBan());
   //  int dem=0;
        //khoi tao mang 2 chieu
        for(int r=0; r<hangso.getChieuRongBan(); r++)
            for(int d=0; d<hangso.getChieuDaiBan();d++)
            {
                //mangChiSo[r][d]=dem;
                mangKT[r+1][d+1]=0;
                mangKT[0][d+1]=2;
                mangKT[hangso.getChieuRongBan()+1][d+1]=2;
                mangKT[r+1][0]=2;
                mangKT[r+1][hangso.getChieuDaiBan()+1]=2;
                if(r%2!=0&&d%2!=0)
                {
                    mangKT[r+1][d+1]=2;
                }

              //  dem++;

            }
        mangKT[1][1]=1;
            //gan hinh

        RanDom(hangso.getSoGach(), 1);//gach
        RanDomTrongGach(hangso.getSotangdomanh(),3);//tangdomanh
        RanDomTrongGach(hangso.getSoTangSLBom(),5);//
        RanDomTrongGach(hangso.getSoTangMang(),7);//
        RanDomTrongGach(hangso.getSoTangTocDo(),9);//
        RanDomNgoaiGach(hangso.getSoLuongQuai(),11);//vitribatdau quai

        mangKT[1][1]=0;



        for(int r=0; r<hangso.getChieuRongBan(); r++)
            for(int d=0; d<hangso.getChieuDaiBan();d++)
            {
                if(mangKT[r+1][d+1]==2)
                {
                    listHinhAnh.add(new HinhAnh(R.drawable.xam));
                }
                else
                    if(mangKT[r+1][d+1]!=0&&mangKT[r+1][d+1]!=2&&mangKT[r+1][d+1]!=11)
                    {
                        listHinhAnh.add(new HinhAnh(R.drawable.gach));

                    }
                    else
                    listHinhAnh.add(new HinhAnh(R.drawable.ovuong));

                if(mangKT[r+1][d+1]==11){//quai

                    imageQuai.setX(grvBan.getX() +(d)*hangso.getChieudaio()/hangso.getTiSopxdp());
                    imageQuai.setY(grvBan.getY() +(r)*hangso.getChieudaio()/hangso.getTiSopxdp());
                    mangKT[r+1][d+1]=0;
                }
            }


        adapter=new HinhanhAdapter(this, R.layout.hinh_anh,listHinhAnh );
        grvBan.setAdapter(adapter);
        txttocDo.setText(String.valueOf(hangso.getBuocDichuyen()));
        txtmang.setText(String.valueOf(hangso.getMangNV()));
        txtbom.setText(String.valueOf(hangso.getSobomNV()));
        txtdoManh.setText(String.valueOf(bom1.getDoManh()));
    }
    void RanDom(int somax, int Sodanhdau)
    {
        int dem=0;
        Random rd1 = new Random();
        Random rd2 = new Random();
        while(dem<somax)
        {
            int x = rd1.nextInt(hangso.getChieuDaiBan());
            int y = rd2.nextInt(hangso.getChieuRongBan());
            while(x %2!= 0&&y %2!= 0)
            {
                x = rd1.nextInt(hangso.getChieuDaiBan());
                y = rd2.nextInt(hangso.getChieuRongBan());
            }

            if (mangKT[y+1][x+1] == 0)
            {
                mangKT[y+1][x+1] = Sodanhdau;
                dem++;

            }
        }
    }
    void RanDomTrongGach(int somax, int Sodanhdau)
    {
        int dem=0;
        Random rd1 = new Random();
        Random rd2 = new Random();
        while(dem<somax)
        {
            int x = rd1.nextInt(hangso.getChieuDaiBan());
            int y = rd2.nextInt(hangso.getChieuRongBan());
            while(x %2!= 0&&y %2!= 0)
            {
                x = rd1.nextInt(hangso.getChieuDaiBan());
                y = rd2.nextInt(hangso.getChieuRongBan());
            }

            if (mangKT[y+1][x+1] == 1)
            {
                mangKT[y+1][x+1] = Sodanhdau;
                dem++;

            }
        }
    }

    void RanDomNgoaiGach(int somax, int Sodanhdau)
    {
        int dem=0;
        Random rd1 = new Random();
        Random rd2 = new Random();
        while(dem<somax)
        {
            int x = rd1.nextInt(hangso.getChieuDaiBan());
            int y = rd2.nextInt(hangso.getChieuRongBan());
            while(x %2!= 0&&y %2!= 0)
            {
                x = rd1.nextInt(hangso.getChieuDaiBan());
                y = rd2.nextInt(hangso.getChieuRongBan());
            }

            if (mangKT[y+1][x+1] == 0)
            {
                mangKT[y+1][x+1] = Sodanhdau;
                dem++;

            }
        }
    }


    void KetThucGame(){

        btnBom.setEnabled(false);
        btnDuoi.setEnabled(false);
        btnPhai.setEnabled(false);
        btnTrai.setEnabled(false);
        btnTren.setEnabled(false);
        txtgameover.setText("Game over!");

}






    void QuaiDiChuyen(){
        int x, y;

        //duongQuaiChay=TimHuong();

        //int t = rd.nextInt(4);
        switch (duongQuaiChay){
            case 0:
                if(DkQuaiTren()){
                    imageQuai.setY(imageQuai.getY()-hangso.buocDiChuyenQuai);

               }
                else
                {
                    /*Quaiflag=0;
                    if(Quaiflag!=5){
                        imageQuai.setY(imageQuai.getY()+hangso.buocDiChuyenQuai);
                    }
                    duongQuaiChay = TimHuong();*/

                   // imageQuai.setY(imageQuai.getY()+hangso.buocDiChuyenQuai);

                    y=(int)((imageQuai.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp()-hangso.buocDiChuyenQuai)/hangso.Chieudaio);
                    x=(int)((imageQuai.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);



                    if(mangKT[y][x-1]==0)
                    {
                        duongQuaiChay=3;
                    }else
                    if(mangKT[y][x+2]==0)
                    {
                        duongQuaiChay=1;
                    }else
                    if(mangKT[y+2][x]==0)
                    {
                        duongQuaiChay=2;
                    }
                }
                break;

            case 1:
                if(DkQuaiPhai()){
                    imageQuai.setX(imageQuai.getX()+hangso.buocDiChuyenQuai);
               }
                else
                {
                   /*Quaiflag=1;
                    if(Quaiflag!=5){
                        imageQuai.setX(imageQuai.getX()-hangso.buocDiChuyenQuai);
                    }
                    duongQuaiChay = TimHuong();*/
                   //imageQuai.setX(imageQuai.getX()-hangso.buocDiChuyenQuai);
                    y=(int)((imageQuai.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
                    x=(int)((imageQuai.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp()+hangso.buocDiChuyenQuai)/hangso.Chieudaio);



                    if(mangKT[y-1][x]==0)
                    {
                        duongQuaiChay=0;
                    }
                    else
                    if(mangKT[y+2][x]==0)
                    {
                        duongQuaiChay=2;
                    }else
                    if(mangKT[y][x-1]==0)
                    {
                        duongQuaiChay=3;
                    }
                }
                break;
            case 2:
                if(DkQuaiDuoi()){
                    imageQuai.setY(imageQuai.getY()+hangso.buocDiChuyenQuai);
                }
                else
                {
                   /* Quaiflag=2;
                    if(Quaiflag!=5){
                        imageQuai.setY(imageQuai.getY()-hangso.buocDiChuyenQuai);
                    }
                    duongQuaiChay=TimHuong();*/

                    //imageQuai.setY(imageQuai.getY()-hangso.buocDiChuyenQuai);

                    y=(int)((imageQuai.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp()+hangso.buocDiChuyenQuai)/hangso.Chieudaio);
                    x=(int)((imageQuai.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);



                    if(mangKT[y][x-1]==0)
                    {
                        duongQuaiChay=3;
                    }else
                    if(mangKT[y][x+2]==0)
                    {
                        duongQuaiChay=1;
                    }else
                    if(mangKT[y-1][x]==0)
                    {
                        duongQuaiChay=0;
                    }

                }
                break;
            case 3:
                if(DkQuaiTrai()){
                    imageQuai.setX(imageQuai.getX()-hangso.buocDiChuyenQuai);
                }
                else
                {
                  /*  Quaiflag=3;
                    if(Quaiflag!=5){
                        imageQuai.setX(imageQuai.getX()+hangso.buocDiChuyenQuai);
                    }
                    duongQuaiChay=TimHuong();*/

                   // imageQuai.setX(imageQuai.getX()+hangso.buocDiChuyenQuai);
                    y=(int)((imageQuai.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
                    x=(int)((imageQuai.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp()-hangso.buocDiChuyenQuai)/hangso.Chieudaio);




                    if(mangKT[y-1][x]==0)
                    {
                        duongQuaiChay=0;

                    }
                    else

                    if(mangKT[y+2][x]==0)
                    {
                        duongQuaiChay=2;
                    }
                    else
                    if(mangKT[y][x+2]==0)
                    {
                        duongQuaiChay=1;
                    }
                }
                break;
            case 4:
                Toast.makeText(MainActivity.this, "444!!!", Toast.LENGTH_SHORT).show();
                //duongQuaiChay=TimHuong();
                break;
            default:
                Toast.makeText(MainActivity.this, "error!!!", Toast.LENGTH_SHORT).show();
                break;


        }

    }
    public  int  TimHuong(){
        int x, y;
        y=(int)((imageQuai.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
        x=(int)((imageQuai.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);

        int t = rd.nextInt(4);
        if(mangKT[y-1][x]==0&&Quaiflag!=0)
        {
            return  0;
        }
        if(mangKT[y][x+1]==0&&Quaiflag!=1)
        {
            return  1;
        }
        if(mangKT[y+1][x]==0&&Quaiflag!=2)
        {
            return  2;
        }
        if(mangKT[y][x-1]==0&&Quaiflag!=3)
        {
            return  3;
        }
        return  4;

    }


    boolean  DkQuaiTren(){
        try {
            int x, y;
            y=(int)((imageQuai.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp()-hangso.buocDiChuyenQuai)/hangso.Chieudaio);
            x=(int)((imageQuai.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);

           /* y--;
            x--;*/
        if(mangKT[y][x]!=0){
            return false;
        }
                return true;

        }
        catch (ArithmeticException e)

        {
            return false;
        }

    }
    boolean  DkQuaiDuoi(){
        try {
            int x, y;
            y=(int)((imageQuai.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp()+hangso.buocDiChuyenQuai)/hangso.Chieudaio);
            x=(int)((imageQuai.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp())/hangso.Chieudaio);

            y++;

            if(mangKT[y][x]!=0){
                return false;
            }
            return true;

        }
        catch (ArithmeticException e)

        {
            Toast.makeText(MainActivity.this, "error!!!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    boolean  DkQuaiPhai(){
        try {
            int x, y;
            y=(int)((imageQuai.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            x=(int)((imageQuai.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp()+hangso.buocDiChuyenQuai)/hangso.Chieudaio);
            x++;





            if(mangKT[y][x]!=0){
                return false;
            }
            return true;

        }
        catch (ArithmeticException e)

        {
            Toast.makeText(MainActivity.this, "error!!!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    boolean  DkQuaiTrai(){
        try {
            int x, y;
            y=(int)((imageQuai.getY()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getY()*hangso.getTiSopxdp())/hangso.Chieudaio);
            x=(int)((imageQuai.getX()*hangso.getTiSopxdp()+hangso.Chieudaio-grvBan.getX()*hangso.getTiSopxdp()-hangso.buocDiChuyenQuai)/hangso.Chieudaio);


            if(mangKT[y][x]!=0){
                return false;
            }
            return true;

        }
        catch (ArithmeticException e)

        {
            Toast.makeText(MainActivity.this, "error!!!", Toast.LENGTH_SHORT).show();
            return false;

        }

    }
    boolean DKfalseQuai(int x, int y){
        if(mangKT[y][x]!=0){
            return true;//tra ve la dung de ham tren tr ve sai
        }
        return false;
    }
    public static float convertPixelsToDp(Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = 1 / (metrics.densityDpi / 160f);
        return dp;

    }

}

