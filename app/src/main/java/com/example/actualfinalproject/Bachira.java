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
import android.widget.EditText;
import android.widget.ToggleButton;

public class Bachira extends AppCompatActivity {


    ConstraintLayout layout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bachira);
        initStrickerButton();
        initStricker2Button();
        initStricker3Button();
        initcolorChanger();
        layout3 = findViewById(R.id.layout3);

        initNamesave();
        setForEditing(false);
        initToggleButton();
        initTextChangeEvents();
    }

    private void initStrickerButton() {
        Button SetButton = findViewById(R.id.buttonStriker);
        SetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bachira.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }

    private void initcolorChanger() {
        Button changeColor = findViewById(R.id.changeColorButton);
        changeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bachira.this, ColorActivity.class);
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
            layout3.setBackgroundColor(colorHolder);
        } else if (colorHolder2 == (0xFF00FF00)) {
            layout3.setBackgroundColor(colorHolder2);
        } else if (colorHolder3 == (0xFFFF0000)) {
            layout3.setBackgroundColor(colorHolder3);
        } else {
            layout3.setBackgroundColor(colorHolder4);
        }
    }
    private void initNamesave() {
        SharedPreferences sp = getSharedPreferences("MyListPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Bachira", "name3");
        editor.putString("Bachira", "name3lowercase");
        editor.apply();
    }
    private void initTextChangeEvents() { //need
        //initialize nine listeners
        EditText nameEdit = findViewById(R.id.editTextTextPersonName3);
        EditText resultEdit = findViewById(R.id.output3);
        nameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(nameEdit.getText().toString().equals("Bachira")|| nameEdit.getText().toString().equals("bachira")){
                    resultEdit.setText("correct!!! You have guessed all correctly");

                }else{
                    resultEdit.setText("wrong try again ");
                }

            }

        });
    }
    private void setForEditing(boolean enabled){
        EditText editname = findViewById(R.id.editTextTextPersonName3);

        editname.setEnabled(enabled);

    }
    private void initToggleButton(){
        ToggleButton toggleButton = findViewById(R.id.toggleButton3);
        toggleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                setForEditing(toggleButton.isChecked());
            }
        });
    }
    private void initStricker2Button() {
        Button MapButton = findViewById(R.id.buttonStriker2);
        MapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bachira.this, Nagi.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initStricker3Button() {
        Button listButton = findViewById(R.id.buttonStriker3);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bachira.this, Bachira.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

}