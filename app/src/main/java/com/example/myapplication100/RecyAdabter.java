package com.example.myapplication100;
/*
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyAdabter  extends RecyclerView.Adapter<RecyAdabter.MyViewHolder> implements Filterable {

    ArrayList<Category> arrayList;
    Context context;
    ArrayList<Category> list;

    public RecyAdabter(ArrayList<Category> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        this.list=new ArrayList<>();
        this.list.addAll(arrayList);
    }

    @NonNull
    @Override
    public RecyAdabter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v=LayoutInflater.from(context).inflate(R.layout.fragment_category,null,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyAdabter.MyViewHolder holder, int position) {

        Category c=arrayList.get(position);
        holder.tv.setText(c.getName1());
        holder.bb.setBackground(c.getImage1());
        holder.bb.setTag(c.getName1());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        Button bb;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.textfrut1);
            bb=itemView.findViewById(R.id.frut1);

            bb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s= (String) bb.getTag();
                    Intent intent=new Intent(context,Tabl.class);
                    intent.putExtra("id",s);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            ArrayList<Category> arrayListfilter=new ArrayList<>();
            if (constraint==null || constraint.length()==0){
                arrayListfilter.addAll(list);
            }else {
                String item=constraint.toString().toLowerCase().trim();
                for (Category x:list){
                    if (x.getName1().toLowerCase().contains(item)){
                        arrayListfilter.add(x);
                    }
                }
            }

            FilterResults filterResults=new FilterResults();
            filterResults.values=arrayListfilter;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            arrayList.clear();
            arrayList.addAll((List)results.values);
            notifyDataSetChanged();


        }
    };
}


 */