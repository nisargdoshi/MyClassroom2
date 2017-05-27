package com.example.nisargdoshi.myclassroom;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                SharedPreferences sharedpreferences = getSharedPreferences(Login.MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                File f = new File("/data/data/" + getPackageName() +  "/shared_prefs/mypref.xml");
                if(f.exists())
                {
                    Intent splesh_intent = new Intent(getBaseContext(), Home.class);
                    startActivity(splesh_intent);
                }
                else {
                    Intent splesh_intent = new Intent(getBaseContext(), Login.class);
                    startActivity(splesh_intent);
                    Toast.makeText(getBaseContext(),"hii",Toast.LENGTH_LONG).show();
                }
            }
        },4000);
    }
    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                SharedPreferences sharedpreferences = getSharedPreferences(Login.MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                File f = new File("/data/data/" + getPackageName() +  "/shared_prefs/mypref.xml");

                if(f.exists())
                {
                    Intent splesh_intent = new Intent(getBaseContext(), Home.class);
                    startActivity(splesh_intent);
                }
                else {
                    Intent splesh_intent = new Intent(getBaseContext(), Login.class);
                    startActivity(splesh_intent);
                    Toast.makeText(getBaseContext(),"hii",Toast.LENGTH_LONG).show();
                }
            }
        },4000);
    }


}
