package com.example.hochnt.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hochnt.karaoketh.R;
import com.example.hochnt.model.Music;

import java.util.List;

/**
 * Created by thaihoc on 7/24/2016.
 */
public class MusicAdapter extends ArrayAdapter<Music> {
    Activity context;
    int resource;
    List<Music> objects;

    public MusicAdapter(Activity context, int resource, List<Music> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    //sau khi lay du lieu
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        //chuyen resource thanh code java => view
        View row = layoutInflater.inflate(this.resource,null);

        TextView txtMa = (TextView) row.findViewById(R.id.txtMaBaiHat);
        TextView txtCaSi = (TextView) row.findViewById(R.id.txtCaSi);
        TextView txtTen = (TextView) row.findViewById(R.id.txtTenBaiHat);

        ImageButton btnLike = (ImageButton) row.findViewById(R.id.btnLike);
        ImageButton btnDislike = (ImageButton) row.findViewById(R.id.btnDislike);

        //get control
        final Music music = this.objects.get(position);
        txtTen.setText(music.getTen());
        txtCaSi.setText(music.getCaSi());
        txtMa.setText(music.getMa());

        //xu ly like, dislike
        if (music.getThich())
        {
            btnLike.setVisibility(View.INVISIBLE);
            btnDislike.setVisibility(View.VISIBLE);
        }
        else
        {
            btnLike.setVisibility(View.VISIBLE);
            btnDislike.setVisibility(View.INVISIBLE);
        }

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyThihc(music);
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyKhongThich(music);
            }
        });
        return row;
        
    }

    private void xuLyKhongThich(Music music) {
        music.setThich(false);
    }

    private void xyLyThihc(Music music) {
        music.setThich(true);
    }

}
