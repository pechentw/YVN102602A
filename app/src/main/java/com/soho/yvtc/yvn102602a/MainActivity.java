package com.soho.yvtc.yvn102602a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String fruits[] = {"芭樂", "芒果", "荔枝", "甘蔗", "鳳梨"};
    Spinner spinner;
    ArrayAdapter<String> adapter;  //泛型 指定 adapter 資料的型態
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);

        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, // android.R.layout 為SDK內建程式建立的常數
                fruits);
        spinner.setAdapter(adapter);
    }
}
