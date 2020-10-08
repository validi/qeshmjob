package com.aurora.qeshmjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class InsertAdverticmend extends AppCompatActivity {
    Spinner spinerCity,spinerTopic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_adverticmend);

        init();
        setSpinerCity();
        setSpinerTopic();
    }

    private void init() {
        spinerCity= (Spinner) findViewById(R.id.spinerCity);
        spinerTopic= (Spinner) findViewById(R.id.spinerTopic);
    ////////////////
    }

    public void setSpinerCity() {
         String[] Group = {"شهر مورد نظر خود را انتخاب کنید", "قشم", "رمکان", "درگهان"};
       // String[] Group = new String[infoCategories.size()];
//        for (int i = 0; i < infoCategories.size(); i++) {
//            Group[i] = infoCategories.get(i).getTitle();
//        }
        // idGroup = 0;
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(InsertAdverticmend.this, R.layout.row_spiner, R.id.txt, Group);
        // adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinerCity.setAdapter(adapter);

        spinerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

               // idGroup = (i);
                //Toast.makeText(insertReport.this, idGroup + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void setSpinerTopic() {
         String[] Group = {"موضوع مورد نظر خود را انتخاب کنید", "حسابدار", "فروشنده", "نقاش"};
       // String[] Group = new String[infoCategories.size()];
//        for (int i = 0; i < infoCategories.size(); i++) {
//            Group[i] = infoCategories.get(i).getTitle();
//        }
        // idGroup = 0;
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(InsertAdverticmend.this, R.layout.row_spiner, R.id.txt, Group);
        // adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinerTopic.setAdapter(adapter);

        spinerTopic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

               // idGroup = (i);
                //Toast.makeText(insertReport.this, idGroup + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBack:
               onBackPressed();
                break;

        }
    }

}
