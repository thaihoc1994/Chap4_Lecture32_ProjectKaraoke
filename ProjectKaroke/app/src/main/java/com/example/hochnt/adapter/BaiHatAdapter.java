package com.example.hochnt.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hochnt.model.BaiHat;
import com.example.hochnt.projectkaroke.R;

import java.util.List;

/**
 * Created by thaihoc on 7/24/2016.
 */
public class BaiHatAdapter extends ArrayAdapter<BaiHat> {
    Activity context;
    int resource;
    List<BaiHat> objects;

    public BaiHatAdapter(Activity context, int resource, List<BaiHat> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource= resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource,null);

        TextView txtMa = (TextView) row.findViewById(R.id.txtMa);
        TextView txtTen = (TextView) row.findViewById(R.id.txtTenBaiHat);
        TextView txtCaSi = (TextView) row.findViewById(R.id.txtCasi);

        ImageButton btnLike = (ImageButton) row.findViewById(R.id.btnLike);
        ImageButton btnDisLike = (ImageButton) row.findViewById(R.id.btnDisLike);

        final BaiHat bh = this.objects.get(position);
        txtTen.setText(bh.getTen());
        txtMa.setText(bh.getMa());
        txtCaSi.setText(bh.getCaSi());

        //xu ly nut thich khong thic
        if (bh.getThich())
        {
            btnLike.setVisibility(View.INVISIBLE);//An
            btnDisLike.setVisibility(View.VISIBLE);

        }
        else
        {
            btnLike.setVisibility(View.VISIBLE);//An
            btnDisLike.setVisibility(View.INVISIBLE);

        }

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThich(bh);

            }
        });
        btnDisLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyKhongThich(bh);
            }
        });
        return row;

    }

    private void xuLyKhongThich(BaiHat bh) {
        bh.setThich(false);
    }

    private void xuLyThich(BaiHat bh) {
        bh.setThich(true);
    }
}
