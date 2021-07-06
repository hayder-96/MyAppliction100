package com.example.myapplication100;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Tabl extends AppCompatActivity {

    ListView listView;
    int in;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tappedactivity);

        listView=findViewById(R.id.seeting);





        Intent ut = getIntent();
        String sn = ut.getStringExtra("id");

        if (sn.equals(getResources().getString(R.string.apple))) {
          ArrayList arrayList=new ArrayList<String>();

          arrayList.add(new CategoryFragment(getResources().getString(R.string.vitamin)));
            arrayList.add(new CategoryFragment(getResources().getString(R.string.water)));
            arrayList.add(new CategoryFragment(getResources().getString(R.string.force)));
            Vitamin vi=new Vitamin(arrayList);
             listView.setAdapter(vi);



        } else {
           ArrayList arrayList=new ArrayList<String>();

            arrayList.add(new CategoryFragment(getResources().getString(R.string.vitamin2)));
            arrayList.add(new CategoryFragment(getResources().getString(R.string.water2)));
            arrayList.add(new CategoryFragment(getResources().getString(R.string.force2)));
            Vitamin vi=new Vitamin(arrayList);
            listView.setAdapter(vi);

        }
    }
    class Vitamin extends BaseAdapter{

        ArrayList<CategoryFragment> list;

        public Vitamin(ArrayList<CategoryFragment> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
          LayoutInflater layoutInflater=getLayoutInflater();
         View v= layoutInflater.inflate(R.layout.activity_maps, (ViewGroup) convertView,false);

         TextView tt=v.findViewById(R.id.sport);
         CategoryFragment cf=list.get(position);
         tt.setText(cf.getNamevitamin());


            return v;
        }
    }






    }


