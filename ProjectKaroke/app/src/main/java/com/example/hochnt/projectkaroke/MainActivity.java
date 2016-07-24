package com.example.hochnt.projectkaroke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.hochnt.adapter.BaiHatAdapter;
import com.example.hochnt.model.BaiHat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvBaiHat;
    ArrayList<BaiHat>dsBaiHat;
    BaiHatAdapter adapterBaiHat;

    ListView lvBaiHatYeuThich;
    ArrayList<BaiHat>dsBaiHatYeuThich;
    BaiHatAdapter adapterBaiHatYeuThich;

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
    }

    private void addEvent() {
        //xy li like, dislike
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (s.equalsIgnoreCase("t1"))
                {
                    xyLyHienThiBaiHatGoc();
                }
                if (s.equalsIgnoreCase("t2"))
                {
                    xyLyHienThiBaiHatYeuThich();
                }
            }
        });

    }

    private void xyLyHienThiBaiHatYeuThich() {
        dsBaiHatYeuThich.clear();
        for(BaiHat baihat: dsBaiHat)
        {
            if(baihat.getThich())
                dsBaiHatYeuThich.add(baihat);
        }
        adapterBaiHatYeuThich.notifyDataSetChanged();
    }

    private void xyLyHienThiBaiHatGoc() {
    }


    private void addControl() {



        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tb1 = tabHost.newTabSpec("t1");
        tb1.setContent(R.id.tab1);
        tb1.setIndicator("",getResources().getDrawable(R.drawable.h1music));
        tabHost.addTab(tb1);

        TabHost.TabSpec tb2 = tabHost.newTabSpec("t2");
        tb2.setContent(R.id.tab2);
        tb2.setIndicator("",getResources().getDrawable(R.drawable.h2favorite));
        tabHost.addTab(tb2);

        lvBaiHat = (ListView) findViewById(R.id.lvBaiHatGoc);
        dsBaiHat = new ArrayList<>();
        adapterBaiHat = new BaiHatAdapter(MainActivity.this,R.layout.item,dsBaiHat);
        lvBaiHat.setAdapter(adapterBaiHat);

        lvBaiHatYeuThich = (ListView) findViewById(R.id.lvBaiHatYeuThich);
        dsBaiHatYeuThich = new ArrayList<>();
        adapterBaiHatYeuThich = new BaiHatAdapter(MainActivity.this,R.layout.item,dsBaiHatYeuThich);
        lvBaiHatYeuThich.setAdapter(adapterBaiHatYeuThich);

        giaLapBaiHat();//gia lap du liec chuan de hien thi (Chua su dung CSDL)
    }

    private void giaLapBaiHat() {
        dsBaiHat.add(new BaiHat("56489","Ly cà phê ban mê","Siu Black",true));
        dsBaiHat.add(new BaiHat("95131","Yêu một người phải chăng lầm lỗi","Ưng Đại Vệ",true));
        dsBaiHat.add(new BaiHat("65498","Riêng một góc trời","Tuấn Ngọc",false));
        dsBaiHat.add(new BaiHat("85436","Nụ Cười","Wanbi Tuấn Anh",true));
        dsBaiHat.add(new BaiHat("69548","Xin hãy thứ tha ","Hồ Ngọc Hà",false));

        adapterBaiHat.notifyDataSetChanged();
    }
}
