package com.example.hochnt.karaoketh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.hochnt.adapter.MusicAdapter;
import com.example.hochnt.model.Music;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Tạo bộ 3 listView<=Data + Adater
    ListView lvBaiHatGoc;
    ArrayList<Music> dsBaiHat;
    MusicAdapter adapterMusic;

    ListView lvBaiHatYeuThich;
    ArrayList<Music> dsBaiHatYeuThich;
    MusicAdapter adapterMusicYeuThich;

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
    }

    private void addEvent() {
        //xu ly tab change hien thi bai hat goc va bai hat yeu thich
        //clear, add lai
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {//chinh la tabId khoi tao cung voi tabSpec
                if (tabId.equalsIgnoreCase("tb1"))
                {
                    xyLyHienThiBaiHatGoc();
                }
                else if (tabId.equalsIgnoreCase("tb2"))
                {
                    xyLyHienThiBaiHatYeuThich();
                }
            }
        });
    }

    private void xyLyHienThiBaiHatYeuThich() {
        dsBaiHatYeuThich.clear();
        for(Music baihat: dsBaiHat)//su dung chung dia chi vung nho
        {
            if(baihat.getThich())
                dsBaiHatYeuThich.add(baihat);
        }
        adapterMusicYeuThich.notifyDataSetChanged();
    }

    private void xyLyHienThiBaiHatGoc() {
    }

    private void addControl() {
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tb1 = tabHost.newTabSpec("tb1");//do ta khoi tao
        tb1.setContent(R.id.tab1);
        tb1.setIndicator("",getResources().getDrawable(R.drawable.h1music));
        tabHost.addTab(tb1);

        TabHost.TabSpec tb2 = tabHost.newTabSpec("tb2");
        tb2.setContent(R.id.tab2);
        tb2.setIndicator("",getResources().getDrawable(R.drawable.h2favorite));
        tabHost.addTab(tb2);

        lvBaiHatGoc = (ListView) findViewById(R.id.lvBaiHatGoc);
        dsBaiHat = new ArrayList<Music>();
        adapterMusic = new MusicAdapter(MainActivity.this,R.layout.itemmusic,dsBaiHat);
        lvBaiHatGoc.setAdapter(adapterMusic);

        lvBaiHatYeuThich = (ListView) findViewById(R.id.lvBaiHatYeuThich);
        dsBaiHatYeuThich = new ArrayList<Music>();
        adapterMusicYeuThich = new MusicAdapter(MainActivity.this,R.layout.itemmusic,dsBaiHatYeuThich);
        lvBaiHatYeuThich.setAdapter(adapterMusicYeuThich);
        giaLapBaiHat();//gia lap du liec chuan de hien thi (Chua su dung CSDL)
    }

    private void giaLapBaiHat() {
        dsBaiHat.add(new Music("56489","Ly cà phê ban mê","Siu Black",true));
        dsBaiHat.add(new Music("95131","Yêu một người phải chăng lầm lỗi","Ưng Đại Vệ",true));
        dsBaiHat.add(new Music("65498","Riêng một góc trời","Tuấn Ngọc",false));
        dsBaiHat.add(new Music("85436","Nụ Cười","Wanbi Tuấn Anh",true));
        dsBaiHat.add(new Music("69548","Xin hãy thứ tha ","Hồ Ngọc Hà",false));

        adapterMusic.notifyDataSetChanged();
    }
}
