package com.soho.yvtc.yvn102602a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String fruits[] = {"芭樂", "芒果", "荔枝", "甘蔗", "鳳梨"}; // 定義右側item
    Spinner spinner; // 宣告左側
    ArrayAdapter<String> adapter;  //泛型 指定 adapter 資料的型態  建立連結轉接器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);  // 取得實體物件

        adapter = new ArrayAdapter<String>(MainActivity.this,  // 建立轉接器與型式
                android.R.layout.simple_list_item_1, // android.R.layout 為SDK內建程式建立的常數
                fruits);
        spinner.setAdapter(adapter);  // 指定連結關係
    }
}
