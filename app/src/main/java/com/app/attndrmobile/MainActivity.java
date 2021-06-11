package com.app.attndrmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButton();
        setName();
    }

    void setName()
    {
        Random rand = new Random();

        SharedPreferences myPrefs;
        TextView tvWelcomeBackTxt;

        tvWelcomeBackTxt = findViewById(R.id.tvWelcomeBackUserTxt);

        String txtWelcome = rand.nextInt(2) == 0 ? "Welcome back, " : "Welcome ";

        myPrefs = getSharedPreferences("user", Context.MODE_PRIVATE);

        String name = myPrefs.getString("username","Default");

        if(name.isEmpty() || name.equals("Default")){
            setDefaultName();
            name = myPrefs.getString("username","Default");
        }

        tvWelcomeBackTxt.setText(txtWelcome + name);
    }


    void setButton()
    {
        Button btnJoinEvent = findViewById(R.id.btn_join_an_event);
        btnJoinEvent.setOnClickListener(this);

        // Move Activity with Data Button
        Button btnEditName = findViewById(R.id.btn_edit_name);
        btnEditName.setOnClickListener(this);
    }

    public void setDefaultName()
    {
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("user", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = myPrefs.edit();

        editor.putString("username", "User");

        editor.apply();
        editor.commit();
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_join_an_event:
                Intent movePageToScanner = new Intent(getApplicationContext(), Scanner.class);
                startActivity(movePageToScanner);
                break;
            case R.id.btn_edit_name:
                Intent movePageToEditName = new Intent(getApplicationContext(), EditName.class);
                startActivity(movePageToEditName);
                break;
        }
    }
}