package com.example.myapplication100;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main2Activity  extends AppCompatActivity {

   ListView listView;
    ArrayList<Category> arrayList;
    MyAdabter m;

    Intent intent;
    int numberid;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tappedactivity);
       listView  = findViewById(R.id.listfrut);


        intent = getIntent();
        numberid = intent.getIntExtra("id", -1);

        if (numberid == 1) {

            arrayList = new ArrayList();

            arrayList.add(new Category(getResources().getString(R.string.apple), getResources().getDrawable(R.drawable.apple)));
            arrayList.add(new Category(getResources().getString(R.string.banana), getResources().getDrawable(R.drawable.banana)));
            arrayList.add(new Category(getResources().getString(R.string.rman), getResources().getDrawable(R.drawable.rman)));
            arrayList.add(new Category(getResources().getString(R.string.grib), getResources().getDrawable(R.drawable.grabes)));
            arrayList.add(new Category(getResources().getString(R.string.orange), getResources().getDrawable(R.drawable.orange)));
            arrayList.add(new Category(getResources().getString(R.string.anans), getResources().getDrawable(R.drawable.ananas)));

            m = new MyAdabter(arrayList, this);

            listView.setAdapter(m);

        } else if (numberid == 2) {

            arrayList = new ArrayList();

            arrayList.add(new Category(getResources().getString(R.string.tmato), getResources().getDrawable(R.drawable.tmato)));
            arrayList.add(new Category(getResources().getString(R.string.batata), getResources().getDrawable(R.drawable.ptato)));
            arrayList.add(new Category(getResources().getString(R.string.bathngan), getResources().getDrawable(R.drawable.bathngan)));
            arrayList.add(new Category(getResources().getString(R.string.khear), getResources().getDrawable(R.drawable.kheaer)));

            m = new MyAdabter(arrayList, this);


            listView.setAdapter(m);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main3, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView1 = (SearchView) menuItem.getActionView();

        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                m.getFilter().filter(newText);

                return false;
            }
        });

        return true;
    }
}


    class MyAdabter extends BaseAdapter implements Filterable {


        ArrayList<Category> arrayList;
        ArrayList<Category> list;
        Context context;


        public MyAdabter(ArrayList<Category> arrayList, Context context) {

            this.arrayList = arrayList;
            this.context = context;
            this.list = new ArrayList<>();
            this.list.addAll(arrayList);

        }


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            //  LayoutInflater layoutInflater=getLayoutInflater();
            View view =LayoutInflater.from(context).inflate(R.layout.fragment_category,null,false);


            TextView textfruit1 = view.findViewById(R.id.textfrut1);
            final Button frut1 = view.findViewById(R.id.frut1);
            //  TextView textfruit2 = view.findViewById(R.id.textfrut2);
            //  Button frut2 = view.findViewById(R.id.frut2);
            final Category c = arrayList.get(position);
            textfruit1.setText(c.getName1());
            frut1.setBackground(c.getImage1());
            //   textfruit2.setText(c.name2);
            //  frut2.setBackground(c.image2);
            frut1.setTag(c.getName1());


            frut1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   String ng = (String) frut1.getTag();
                    Intent io = new Intent(context, Tabl.class);
                    io.putExtra("id", ng);
                    context.startActivity(io);


                }

            });
            return view;
        }


        @Override
        public Filter getFilter() {

            return filter;
        }

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                ArrayList<Category> listflter = new ArrayList<>();
                if (constraint == null || constraint.length() == 0) {

                    listflter.addAll(list);
                } else {

                    String filterList = constraint.toString().toLowerCase().trim();
                    for (Category item : list) {

                        if (item.getName1().toLowerCase().contains(filterList)) {
                            listflter.add(item);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = listflter;
                return results;


            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                arrayList.clear();
                arrayList.addAll((List) results.values);
                notifyDataSetChanged();
            }


        };
    }


















