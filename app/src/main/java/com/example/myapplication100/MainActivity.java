package com.example.myapplication100;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.app.Service;
import android.app.TabActivity;
import android.app.TaskStackBuilder;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.Vibrator;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.VideoView;

import com.androidquery.AQuery;
import com.google.android.material.tabs.TabLayout;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.example.mylibrary.*;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    Button bu;

    ImageView t;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        bu=findViewById(R.id.butdin);


        Animation a=AnimationUtils.loadAnimation(this,R.anim.main_3);
        bu.startAnimation(a);


    }
}







/*
        tv=findViewById(R.id.textresult);
        signed="0";
        screenText="";
        celtresult="0";



    }

    public void print(View view) {

        celtresult="0";
        if (signed.equals("0")) {
            Button bu = ((Button) view);
            screenText += bu.getText().toString();
            tv.setText(screenText);
            a = Double.parseDouble(screenText);
        }else {

            Button bt = ((Button) view);
            screenText += bt.getText().toString();
            tv.setText(screenText);
            b = Double.parseDouble(screenText);
        }
    }

    public void clear(View view) {

        screenText="0";
        signed="0";
        celtresult="0";
        tv.setText("0");
    }

    public void printt(View view) {

        Button button=((Button)view);

        sign=button.getText().toString();
        tv.setText(sign);
        signed="1";
        screenText="";

        }


    public void printresult(View view) {

        if (sign.equals("+")){

            c=a+b;
        }else if (sign.equals("-")){
            c=a-b;
        }
        else if (sign.equals("*")){
            c=a*b;
        }
        else if (sign.equals("/")){
            c=a/b;
        }
        celtresult=Double.toString(c);
        tv.setText(celtresult);
        screenText="0";
        signed="0";


    }
}


 */


































    /*
    class MyAsynk extends AsyncTask<String,Integer,String>{


        PowerManager.WakeLock wakeLock;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            PowerManager p= (PowerManager) getBaseContext().getSystemService(Context.POWER_SERVICE);
            wakeLock=p.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,getClass().getName());
             wakeLock.acquire();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.incrementProgressBy(values[0]);
            loc1.setText(progressBar.getProgress()+"/100");

        }

        @Override
        protected String doInBackground(String... strings) {
            InputStream input=null;
            OutputStream output=null;
            HttpURLConnection connection=null;
            try{
                URL url = new URL(strings[0]);
                 connection=(HttpURLConnection)url.openConnection();
                 connection.connect();
                 if (connection.getResponseCode() !=HttpURLConnection.HTTP_OK){
                     return "server"+connection.getResponseCode()+""+connection.getResponseMessage();
                 }
                        int fileLength=connection.getContentLength();
                   String[] filen=strings[0].split("/");
                         input=connection.getInputStream();
                         output=openFileOutput("downlod"+filen[filen.length-1],Context.MODE_PRIVATE);
                         byte[] data=new byte[4000];
                         long total=0;
                         int content;
                         while ((content=input.read(data))!=-1){
                             if (isCancelled()){
                                 input.close();
                                 return null;
                             }
                             total+=content;
                             if (fileLength>0)
                                 publishProgress((int) (total*100/fileLength));
                             output.write(data,0,content);
                         }
            }catch (Exception e){

            }finally {
                try {
                    if (output != null)
                        output.close();
                    if (input != null)
                        input.close();
                }catch (Exception e){

                }
            }

            return null;
        }
    }
}


     */


























        /*
    }

    public void show(View view) {
        String uri="https://www.google.com/";

        MyAsink my=new MyAsink();
        my.execute(uri);

    }


    class MyAsink extends AsyncTask<String, String, String> {

        String txt;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txt="";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ser.setText(txt);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            ser.setText(values[0]);
        }

        @Override
        protected String doInBackground(String... strings) {
            publishProgress("open connection");
            try {
                URL url = new URL(strings[0]);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream i = new BufferedInputStream(httpURLConnection.getInputStream());
                publishProgress("start read buffer");
                txt = printtext(i);
                i.close();
            } catch (Exception e) {
                publishProgress("not data");
            }

            return null;
        }

        public String printtext(InputStream inputStream) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            String t;
            try {
                while ((t = bufferedReader.readLine()) != null) {

                    line += t;
                }

            } catch (Exception e) {

            }
            return line;
        }
    }
}

         */






