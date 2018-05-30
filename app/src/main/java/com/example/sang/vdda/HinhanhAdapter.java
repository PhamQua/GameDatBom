package com.example.sang.vdda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by asus on 01/03/2018.
 */

public class HinhanhAdapter extends BaseAdapter {


    private Context context;
    private  int layout;
    private List<HinhAnh> hinhAnhList;
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public List<HinhAnh> getHinhAnhList() {
        return hinhAnhList;
    }

    public void setHinhAnhList(List<HinhAnh> hinhAnhList) {
        this.hinhAnhList = hinhAnhList;
    }



    public HinhanhAdapter(Context context, int layout, List<HinhAnh> hinhAnhList) {
        this.context = context;
        this.layout = layout;
        this.hinhAnhList = hinhAnhList;
    }

    @Override
    public int getCount() {
        return hinhAnhList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private  class  ViewHolder{
        ImageView imgHinh;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            holder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout, null);
            holder.imgHinh= (ImageView) convertView.findViewById(R.id.ovuong);
            convertView.setTag(holder);
        } else {
            holder= (ViewHolder) convertView.getTag();
        }
        HinhAnh hinhAnh=hinhAnhList.get(position);
        holder.imgHinh.setImageResource(hinhAnh.getHinh());
        return convertView;
    }
}
