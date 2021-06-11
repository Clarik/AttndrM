package com.app.attndrmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditName extends AppCompatActivity implements View.OnClickListener{

    EditText edtText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);
        edtText = findViewById(R.id.txt_name_holder);

        setButton();
        displayName();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_edit_name:
                changeName();
            case R.id.btn_back_to_home:
                Intent moveIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(moveIntent);
                break;
        }
    }

    void setButton()
    {
        Button btnChangeName;
        Button btnBackToHome;
        btnChangeName = findViewById(R.id.btn_edit_name);
        btnChangeName.setOnClickListener(this);
        btnBackToHome = findViewById(R.id.btn_back_to_home);
        btnBackToHome.setOnClickListener(this);
    }


    void displayName()
    {
        SharedPreferences myPrefs;

        myPrefs = getSharedPreferences("user", Context.MODE_PRIVATE);

        String name = myPrefs.getString("username","Default");
        if(name.isEmpty() || name.equals("Default")){
            setDefaultName();
            name =  myPrefs.getString("username","Default");
        }

        edtText.setText(name);

    }

    void changeName()
    {
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("user", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = myPrefs.edit();

        editor.putString("username", edtText.getText().toString());

        editor.apply();
        editor.commit();
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



}