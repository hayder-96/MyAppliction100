package com.example.mylibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Ads {
    Context context;
    public Ads(Context context) {
        this.context=context;
    }

    public void Didplay(){

        new AlertDialog.Builder(context).setTitle("CLOSE").setMessage("ARE YOU SURE")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

    }
}
