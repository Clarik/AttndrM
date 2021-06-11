package com.app.attndrmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowEventDetail extends AppCompatActivity implements View.OnClickListener {

    TextView tvUsername, tvEventName, tvSpeakerName, tvLocation, tvDate, tvTime, tvLoginTime;
    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_event_detail);
        setUpTextView();
    }
    void setUpButton()
    {
        btnLogOut = findViewById(R.id.btn_eLogOut);
        btnLogOut.setOnClickListener(this);
    }


    void setUpTextView()
    {
        tvUsername = findViewById(R.id.tveUsername);
        tvEventName = findViewById(R.id.tveName);
        tvSpeakerName = findViewById(R.id.tveSpeakerName);
        tvLocation = findViewById(R.id.tveLocation);
        tvDate = findViewById(R.id.tveDate);
        tvTime = findViewById(R.id.tveTime);
        tvLoginTime = findViewById(R.id.tveLoginTime);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_eLogOut:
                logOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    void logOut()
    {

    }

}


