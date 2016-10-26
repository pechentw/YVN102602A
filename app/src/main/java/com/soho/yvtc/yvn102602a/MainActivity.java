package com.soho.yvtc.yvn102602a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ArrayList mylist;
//    String fruits[] = {"芭樂", "芒果", "荔枝", "甘蔗", "鳳梨"}; // 定義右側item
    Spinner spinner, spinner2; // 宣告左側
    ArrayAdapter<String> adapter;  //泛型 指定 adapter 資料的型態  建立連結轉接器

    ArrayList<Map<String, String>> mylist2;
    SimpleAdapter adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = new ArrayList<>();
        mylist.add("芭樂");//0
        mylist.add("芒果");//1
        mylist.add("荔枝");//2
        mylist.add("甘蔗");//3
        mylist.add("鳳梨");//4
     //   mylist.remove(1); // remove 1 芒果
        spinner = (Spinner) findViewById(R.id.spinner);  // 取得實體物件

        adapter = new ArrayAdapter<String>(MainActivity.this,  // 建立轉接器與型式
                android.R.layout.simple_list_item_1, // android.R.layout 為SDK內建程式建立的常數
                mylist);
        spinner.setAdapter(adapter);  // 指定連結關係

        spinner2 = (Spinner) findViewById(R.id.spinner2);

        mylist2 = new ArrayList<>();
        HashMap<String, String> m1 = new HashMap<>();
        m1.put("city", "台北");
        m1.put("code", "02");
        mylist2.add(m1);
        HashMap<String, String> m2 = new HashMap<>();
        m2.put("city", "台中");
        m2.put("code", "04");
        mylist2.add(m2);
        HashMap<String, String> m3 = new HashMap<>();
        m3.put("city", "高雄");
        m3.put("code", "07");
        mylist2.add(m3);

        adapter2 = new SimpleAdapter(MainActivity.this, mylist2, android.R.layout.simple_list_item_2,
                new String[]{"city", "code"}, new int[] {android.R.id.text1, android.R.id.text2});

        spinner2.setAdapter(adapter2);
    }
    public void clickadd(View v)
    {
        EditText ed = (EditText) findViewById(R.id.editText);
        String str = ed.getText().toString();
        mylist.add(str);
        adapter.notifyDataSetChanged();
    }
    public void clickdelete(View v)
    {
        Log.d("MYLOG","S" + spinner.getSelectedItemPosition() + mylist.size());
        if (mylist.size() == 0) {
            Log.d("MYLOG","list is empty");
        }
        else {
            mylist.remove(spinner.getSelectedItemPosition());
            adapter.notifyDataSetChanged();
        }

    }
}
