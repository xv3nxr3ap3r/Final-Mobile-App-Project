package com.example.actualfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        initGroupColorChange();
        initColorActivity();
        initStrickerButton();
        initStricker2Button();
        initStricker3Button();
    }
    private void initColorActivity() {
        SharedPreferences sharedPref = getSharedPreferences("MyListPreferences", Context.MODE_PRIVATE);
        //int colorHolder = sharedPref.getInt("colorGroup", 0xFF00FF00);//defaulting it to ascending
        int colorHolder = sharedPref.getInt("colorGroup", 0xFF00FF00);
        int colorHolder2 = sharedPref.getInt("colorGroup", 0xFF00FF00);
        int colorHolder3 = sharedPref.getInt("colorGroup",0xFFFF0000 );
        RadioButton rbBlue = findViewById(R.id.blueButton);
        RadioButton rbGreen = findViewById(R.id.greenButton);
        RadioButton rbRed = findViewById(R.id.redButton);
        RadioButton rbYellow = findViewById(R.id.yellowButton);
        if (colorHolder == 0xFF00FF00) {
            rbGreen.setChecked(true);
        } else if (colorHolder2 == 0xFF0000FF) {
            rbBlue.setChecked(true);
        } else if (colorHolder3 == 0xFFFF0000) {
            rbRed.setChecked(true);
        } else {
            rbYellow.setChecked(true);
        }

    }

    private void initGroupColorChange(){
        RadioGroup rgcc = findViewById(R.id.colorGroup);
        RadioButton rbBlue = findViewById(R.id.blueButton);
        RadioButton rbGreen = findViewById(R.id.greenButton);
        RadioButton rbRed = findViewById(R.id.redButton);
        RadioButton rbYellow = findViewById(R.id.yellowButton);
        rgcc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbBlue.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyListPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorGroup", 0xFF0000FF);
                    editor.apply();
                } else if (rbGreen.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyListPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorGroup", 0xFF00FF00);
                    editor.apply();
                }else if(rbRed.isChecked()){
                    SharedPreferences sp = getSharedPreferences("MyListPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorGroup", 0xFFFF0000);
                    editor.apply();
                }else if(rbYellow.isChecked()){
                    SharedPreferences sp = getSharedPreferences("MyListPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("colorGroup", 0xFFFFFF00);
                    editor.apply();
                }
            }



        });
    }

    private void initStrickerButton(){
        Button SetButton = findViewById(R.id.buttonStriker);
        SetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ColorActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }


    private void initStricker2Button(){
        Button MapButton = findViewById(R.id.buttonStriker2);
        MapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ColorActivity.this, Nagi.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initStricker3Button(){
        Button listButton = findViewById(R.id.buttonStriker3);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ColorActivity.this, Bachira.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

}}