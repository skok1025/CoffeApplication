package com.kimsh.skok.angel_in_us;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent splash = new Intent(getApplicationContext(), Splash.class);
        startActivity(splash); // 인텐트를 사용하여 스플래쉬 구현


    }

    public void goUser(View V){
        Intent myIntent=new Intent(getApplicationContext(),UserMain.class);
        startActivity(myIntent);


    }
}