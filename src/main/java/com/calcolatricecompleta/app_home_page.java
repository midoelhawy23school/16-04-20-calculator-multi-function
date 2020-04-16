package com.calcolatricecompleta;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class app_home_page extends AppCompatActivity {
    Spinner Splanguages;
    Button BtnGo;
    TextView TVchange;
    private static final String[] paths = {"Italian","Arabic", "English"};
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Locale mylang= new Locale("ar_EG");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home_page);
        Splanguages = (Spinner) findViewById(R.id.Splanguages);
        TVchange = findViewById(R.id.TVchange);
        BtnGo = findViewById(R.id.BtnGo);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(app_home_page.this,
                android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Splanguages.setAdapter(adapter);


      //  setAppLocale("ar");
        BtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String LangSelect =  Splanguages.getSelectedItem().toString();

               switch (LangSelect){
                   case "Arabic":
                       setAppLocale("ar");
                       break;
                   case "English"  :
                       setAppLocale("en");
                       break;
                   case "Italian" :
                       setAppLocale("it");
                       break;
               }


               /* try {
                    //TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                go();
            }
        });

       // startActivity(intent);
       // TVchange.setText(getString(R.string.app_name));

    }


    public void go(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setAppLocale(String localeCode){
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(new Locale(localeCode.toLowerCase()));
        resources.updateConfiguration(configuration, displayMetrics);
        configuration.locale = new Locale(localeCode.toLowerCase());
        resources.updateConfiguration(configuration, displayMetrics);

        recreate();
    }










}
