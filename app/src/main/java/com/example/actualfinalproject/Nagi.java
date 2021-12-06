package com.example.actualfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

public class Nagi extends AppCompatActivity {
    ConstraintLayout layout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nagi);
        initStricker2Button();
        initStrickerButton();
        initStricker3Button();
        initcolorChanger();
        initNamesave();
        initNamesave();
        setForEditing(false);
        initToggleButton();

        initTextChangeEvents();
        layout2 = findViewById(R.id.layout2);
    }

    private void initcolorChanger() {
        Button changeColor = findViewById(R.id.changeColorButton2);
        changeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nagi.this, ColorActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("MyListPreferences", Context.MODE_PRIVATE);
        int colorHolder = sharedPref.getInt("colorGroup", 0xFF0000FF);
        int colorHolder2 = sharedPref.getInt("colorGroup", 0xFF00FF00);
        int colorHolder3 = sharedPref.getInt("colorGroup", 0xFFFF0000);
        int colorHolder4 = sharedPref.getInt("colorGroup", 0xFFFFFF00);

        if (colorHolder == (0xFF00FF00)) {
            layout2.setBackgroundColor(colorHolder);
        } else if (colorHolder2 == (0xFF00FF00)) {
            layout2.setBackgroundColor(colorHolder2);
        } else if (colorHolder3 == (0xFFFF0000)) {
            layout2.setBackgroundColor(colorHolder3);
        } else {
            layout2.setBackgroundColor(colorHolder4);
        }
    }

    private void initNamesave() {
        SharedPreferences sp = getSharedPreferences("MyListPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Nagi", "name2");
        editor.putString("Nagi", "name2lowercase");
        editor.apply();
    }
    private void initTextChangeEvents() { //need
        //initialize nine listeners
        EditText nameEdit = findViewById(R.id.editTextTextPersonName2);
        EditText resultEdit = findViewById(R.id.output2);
        nameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(nameEdit.getText().toString().equals("Nagi")|| nameEdit.getText().toString().equals("nagi") ){
                    resultEdit.setText("correct name move on to the next striker");

                }else{
                    resultEdit.setText("wrong try again ");
                }

            }

        });
    }
    private void setForEditing(boolean enabled){
        EditText editname = findViewById(R.id.editTextTextPersonName2);

        editname.setEnabled(enabled);

    }
    private void initToggleButton(){
        ToggleButton toggleButton = findViewById(R.id.toggleButton2);
        toggleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                setForEditing(toggleButton.isChecked());
            }
        });
    }
    private void initStrickerButton(){
        Button SetButton = findViewById(R.id.buttonStriker);
        SetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nagi.this, MainActivity.class);
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
                Intent intent = new Intent(Nagi.this, Nagi.class);
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
                Intent intent = new Intent(Nagi.this, Bachira.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
}}