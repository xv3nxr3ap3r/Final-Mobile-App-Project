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

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStricker2Button();
        initStricker3Button();
        initStrickerButton();
        initcolorChanger();
        initNamesave();
        setForEditing(false);
        initToggleButton();
        layout = findViewById(R.id.layout);
        initTextChangeEvents();
    }
    private void initcolorChanger() {
        Button changeColor = findViewById(R.id.changeColorButton3);
        changeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColorActivity.class);
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
            layout.setBackgroundColor(colorHolder);
        } else if (colorHolder2 == (0xFF00FF00)) {
            layout.setBackgroundColor(colorHolder2);
        } else if (colorHolder3 == (0xFFFF0000)) {
            layout.setBackgroundColor(colorHolder3);
        } else {
            layout.setBackgroundColor(colorHolder4);
        }
    }
    private void initNamesave() {
        SharedPreferences sp = getSharedPreferences("MyListPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Isagi", "name");
        editor.putString("isagi", "namelowercase");
        editor.apply();
    }
    private void initTextChangeEvents() { //need
        //initialize nine listeners
        EditText nameEdit = findViewById(R.id.editTextTextPersonName);
        EditText resultEdit = findViewById(R.id.output);
        nameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(nameEdit.getText().toString().equals("Isagi")||nameEdit.getText().toString().equals("isagi") ){
                    resultEdit.setText("correct name move on to the next striker");

                }else{
                    resultEdit.setText("wrong try again ");
                }

            }

        });
    }
    private void setForEditing(boolean enabled){
        EditText editname = findViewById(R.id.editTextTextPersonName);

        editname.setEnabled(enabled);

    }
    private void initToggleButton(){
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
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
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
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
                Intent intent = new Intent(MainActivity.this, Nagi.class);
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
                Intent intent = new Intent(MainActivity.this, Bachira.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

}}