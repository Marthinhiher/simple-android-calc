package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class viewactivty extends AppCompatActivity {
 String [] item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewactivty);



        ListView lstvw=(ListView)findViewById(R.id.lst);
        item=getResources().getStringArray(R.array.Universities);
        ArrayAdapter<String> adpter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);
        lstvw.setAdapter(adpter);

        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=adpter.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });

    }
}